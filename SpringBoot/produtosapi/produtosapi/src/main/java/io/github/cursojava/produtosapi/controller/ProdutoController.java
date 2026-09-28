package io.github.cursojava.produtosapi.controller;

import io.github.cursojava.produtosapi.Repository.ProdutoRepository;
import io.github.cursojava.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
       // return produto.orElse(null);
    }

    @GetMapping
    public List<Produto> buscarProdutos(@RequestParam("nome") String nome) {
          List<Produto> produtos = produtoRepository.findByNome(nome);
          return produtos;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @PutMapping("{id}")
    public void atualizarProduto(@PathVariable("id") String id, @RequestBody Produto produto){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if(produtoExistente.isPresent()){
            produto.setId(id);
            produtoRepository.save(produto);
        }
    }

    @DeleteMapping("{id}")
    public void  excluir(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }
}
