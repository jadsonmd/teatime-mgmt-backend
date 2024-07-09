package com.teatime.service;

import com.teatime.dto.ReceberEstoqueDTO;
import com.teatime.dto.TransferenciaEstoqueDTO;
import com.teatime.dto.TransferirEstoqueDTO;
import com.teatime.enums.TipoMovimentacao;
import com.teatime.model.TransferenciaEstoque;
import com.teatime.model.TransferenciaEstoqueDetalhe;
import com.teatime.repository.TransferenciaEstoqueDetalheRepository;
import com.teatime.repository.TransferenciaEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaEstoqueService {

    @Autowired
    private TransferenciaEstoqueRepository transferenciaEstoqueRepository;

    @Autowired
    private TransferenciaEstoqueDetalheRepository transferenciaEstoqueDetalheRepository;

    public TransferenciaEstoque createTransferenciaEstoque(TransferenciaEstoqueDTO transferenciaEstoqueDTO) {

        Optional<TransferenciaEstoque> transferenciaEstoque = null;
        if (TipoMovimentacao.SAIDA.name().equals(transferenciaEstoqueDTO.getTpMovimentacao().name())) {
            transferenciaEstoque = transferenciaEstoqueRepository.
                    findByIdParceiroAndIdProdutoItemAndIdUnidade(
                            transferenciaEstoqueDTO.getIdParceiro(),
                            transferenciaEstoqueDTO.getIdProdutoItem(),
                            transferenciaEstoqueDTO.getIdUnidadeOrigem()
                    );

        } else {
            transferenciaEstoque = transferenciaEstoqueRepository.
                    findByIdParceiroAndIdProdutoItemAndIdUnidade(
                            transferenciaEstoqueDTO.getIdParceiro(),
                            transferenciaEstoqueDTO.getIdProdutoItem(),
                            transferenciaEstoqueDTO.getIdUnidadeDestino()
                    );
        }

        transferenciaEstoque.ifPresentOrElse(transf -> {
            if (TipoMovimentacao.ENTRADA.name().equals(transferenciaEstoqueDTO.getTpMovimentacao().name())) {
                transf.setQuantidade(transf.getQuantidade() + transferenciaEstoqueDTO.getQuantidade());
            } else {
                transf.setQuantidade(transf.getQuantidade() - transferenciaEstoqueDTO.getQuantidade());
            }

            transferenciaEstoqueRepository.save(transf);

            saveTransferenciaEstoqueDetalhe(transf.getId(), transferenciaEstoqueDTO);
        }, () -> {
            TransferenciaEstoque transf = new TransferenciaEstoque();
            transf.setIdProdutoItem(transferenciaEstoqueDTO.getIdProdutoItem());
            transf.setIdParceiro(transferenciaEstoqueDTO.getIdParceiro());
            transf.setQuantidade(transferenciaEstoqueDTO.getQuantidade());
            transf.setIdUnidade(transferenciaEstoqueDTO.getIdUnidadeDestino());

            transferenciaEstoqueRepository.save(transf);

            saveTransferenciaEstoqueDetalhe(transf.getId(), transferenciaEstoqueDTO);
        });

        return transferenciaEstoque.orElse(null);
    }

    private void saveTransferenciaEstoqueDetalhe(String idTransferenciaEstoque, TransferenciaEstoqueDTO transferenciaEstoqueDTO) {
        TransferenciaEstoqueDetalhe transferenciaEstoqueDetalhe = new TransferenciaEstoqueDetalhe();

        transferenciaEstoqueDetalhe.setIdTransferenciaEstoque(idTransferenciaEstoque);

        transferenciaEstoqueDetalhe.setIdUnidadeDestino(transferenciaEstoqueDTO.getIdUnidadeDestino());
        transferenciaEstoqueDetalhe.setIdUnidadeOrigem(transferenciaEstoqueDTO.getIdUnidadeOrigem());
        transferenciaEstoqueDetalhe.setIdUsuarioRecebeu(transferenciaEstoqueDTO.getIdUsuarioRecebeu());
        transferenciaEstoqueDetalhe.setIdUsuarioTransferiu(transferenciaEstoqueDTO.getIdUsuarioTranferiu());
        transferenciaEstoqueDetalhe.setQuantidade(transferenciaEstoqueDTO.getQuantidade());
        transferenciaEstoqueDetalhe.setDataTransferencia(new Date());
        transferenciaEstoqueDetalhe.setTipoMovimentacao(transferenciaEstoqueDTO.getTpMovimentacao().name());
        transferenciaEstoqueDetalhe.setObservacao(transferenciaEstoqueDTO.getObservacao());

        transferenciaEstoqueDetalheRepository.save(transferenciaEstoqueDetalhe);
    }

    public TransferenciaEstoque transferirStock(TransferirEstoqueDTO transferirEstoqueDTO) {
        // TODO Não permitir transferir caso a quantidade esteja zerada.
        if (transferirEstoqueDTO.getQuantidade() == 0) {
            throw new RuntimeException("Não existe quantidade de estoque disponível nessa unidade.");
        }

        TransferenciaEstoqueDTO transferenciaEstoqueDTO = new TransferenciaEstoqueDTO();
        transferenciaEstoqueDTO.setIdParceiro(transferirEstoqueDTO.getIdParceiro());
        transferenciaEstoqueDTO.setIdProdutoItem(transferirEstoqueDTO.getIdProdutoItem());
        transferenciaEstoqueDTO.setIdUnidadeDestino(transferirEstoqueDTO.getIdUnidadeDestino());
        transferenciaEstoqueDTO.setIdUnidadeOrigem(transferirEstoqueDTO.getIdUnidadeOrigem());
        transferenciaEstoqueDTO.setQuantidade(transferirEstoqueDTO.getQuantidade());
        transferenciaEstoqueDTO.setTpMovimentacao(TipoMovimentacao.SAIDA);
        transferenciaEstoqueDTO.setObservacao(transferirEstoqueDTO.getObservacao());
        transferenciaEstoqueDTO.setIdUsuarioTranferiu(transferirEstoqueDTO.getIdUsuarioTransferiu());

        return createTransferenciaEstoque(transferenciaEstoqueDTO);
    }

    public TransferenciaEstoque receberStock(ReceberEstoqueDTO receberEstoqueDTO) {

        Optional<TransferenciaEstoqueDetalhe> transferenciaEstoqueDetalheOptional = transferenciaEstoqueDetalheRepository.
                findById(receberEstoqueDTO.getIdTransferenciaEstoqueDetalhe());

        transferenciaEstoqueDetalheOptional.ifPresentOrElse(transferenciaEstoqueDetalhe -> {
            TransferenciaEstoqueDTO transferenciaEstoqueDTO = new TransferenciaEstoqueDTO();
            transferenciaEstoqueDTO.setIdParceiro(transferenciaEstoqueDetalhe.getTransferenciaEstoque().getIdParceiro());
            transferenciaEstoqueDTO.setIdProdutoItem(transferenciaEstoqueDetalhe.getTransferenciaEstoque().getIdProdutoItem());
            transferenciaEstoqueDTO.setIdUnidadeDestino(transferenciaEstoqueDetalhe.getIdUnidadeDestino());
            transferenciaEstoqueDTO.setIdUnidadeOrigem(transferenciaEstoqueDetalhe.getIdUnidadeOrigem());
            transferenciaEstoqueDTO.setQuantidade(transferenciaEstoqueDetalhe.getQuantidade());
            transferenciaEstoqueDTO.setTpMovimentacao(TipoMovimentacao.ENTRADA);
            transferenciaEstoqueDTO.setObservacao(receberEstoqueDTO.getObservacao());
            transferenciaEstoqueDTO.setIdUsuarioTranferiu(transferenciaEstoqueDetalhe.getIdUsuarioTransferiu());
            transferenciaEstoqueDTO.setIdUsuarioRecebeu(receberEstoqueDTO.getIdUsuarioRecebeu());

            transferenciaEstoqueDetalhe.setIdUsuarioRecebeu(receberEstoqueDTO.getIdUsuarioRecebeu());
            transferenciaEstoqueDetalheRepository.save(transferenciaEstoqueDetalhe);

            createTransferenciaEstoque(transferenciaEstoqueDTO);
        }, () -> {
            throw new RuntimeException("Não foi possível encontrar a transferência de estoque.");
        });

        return transferenciaEstoqueDetalheOptional.get().getTransferenciaEstoque();
    }

    public List<TransferenciaEstoque> getAllTransferenciaStock() {

        return transferenciaEstoqueRepository.findAll();
    }

    public List<TransferenciaEstoqueDetalhe> getAllTransferenciaStockPendenteRecebimento() {
        return transferenciaEstoqueDetalheRepository.findAllTransferenciaStockPendenteRecebimento(TipoMovimentacao.SAIDA.name());
    }
}
