import React, { useState, useEffect } from 'react';
import axios from 'axios';

import '../../styles/formulario.css';

const ModalLocal = ({ local, onSubmit, onClose }) => {
  const [id, setId] = useState('');
  const [nome, setNome] = useState('');
  const [endereco, setEndereco] = useState('');
  const [telefone, setTelefone] = useState('');
  const [bairro, setBairro] = useState('');
  const [cep, setCep] = useState('');
  const [erro, setErro] = useState('');

  useEffect(() => {
    if (local) {
      setId(local.id);
      setNome(local.nome);
      setEndereco(local.endereco);
      setTelefone(local.telefone);
      setBairro(local.bairro);
      setCep(local.cep);
    }
  }, [local]);

  const Erro = ({ mensagem, sucesso }) => {
    const estilo = sucesso ? 'mensagem-sucesso' : 'mensagem-fracasso';
    return <div className={estilo}>{mensagem}</div>;
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    if (nome === '') {
      setErro({ mensagem: 'Campo obrigatório: Nome', sucesso: false });
      return;
    }

    if (endereco === '') {
      setErro({ mensagem: 'Campo obrigatório: Endereço', sucesso: false });
      return;
    }

    if (telefone === '') {
      setErro({ mensagem: 'Campo obrigatório: Telefone', sucesso: false });
      return;
    }

    if (bairro === '') {
      setErro({ mensagem: 'Campo obrigatório: Bairro', sucesso: false });
      return;
    }

    if (cep === '') {
      setErro({ mensagem: 'Campo obrigatório: CEP', sucesso: false });
      return;
    }

    let data = {};

    if (id) {
      data = {
        id: id,
        nome: nome,
        endereco: endereco,
        telefone: telefone,
        bairro: bairro,
        cep: cep,
      };
      // Atualização (Editar)
      axios
        .put(`http://localhost:8080/api/local`, data)
        .then((response) => {
          console.log('Dados atualizados com sucesso:', response.data);
          onSubmit(response.data);
          setId('');
          setNome('');
          setEndereco('');
          setTelefone('');
          setBairro('');
          setCep('');
          setErro('');
          onClose();
        })
        .catch((error) => {
          console.error('Erro ao atualizar os dados:', error);
          setErro({ mensagem: 'Erro ao atualizar o local. Por favor, tente novamente.', sucesso: false });
        });
    } else {
      data = {
        nome: nome,
        endereco: endereco,
        telefone: telefone,
        bairro: bairro,
        cep: cep,
      };
      // Inserção (Salvar)
      axios
        .post('http://localhost:8080/api/local', data)
        .then((response) => {
          console.log(response.data, response.data.status);
          if (response.data.status === 200) {
            setId('');
            setNome('');
            setEndereco('');
            setTelefone('');
            setBairro('');
            setCep('');
            setErro('');
            onClose();
          } else {
            setErro({ mensagem: 'Erro ao adicionar o local. Por favor, tente novamente.', sucesso: false });
          }
        })
        .catch((error) => {
          console.error('Erro ao salvar os dados:', error);
          setErro({ mensagem: 'Erro ao adicionar o local. Por favor, tente novamente.', sucesso: false });
        });
    }
  };

  const handleModalContentClick = (event) => {
    // Impede a propagação do evento de clique para o contêiner do modal
    event.stopPropagation();
  };

  const handleModalClose = () => {
    setErro('');
    onClose();
  };

  return (
    <div className="modal" onClick={handleModalClose}>
      <div className="modal-content" onClick={handleModalContentClick}>
        <h2>{id ? 'Editar Local' : 'Inserir Local'}</h2>
        {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
        <form onSubmit={handleSubmit} className="local-form">
          <div className="form-group">
            <label htmlFor="id">ID:</label>
            <input type="number" id="id" value={id} onChange={(e) => setId(e.target.value)} disabled />
          </div>
          <div className="form-group">
            <label htmlFor="nome">Nome:{' '}
              {nome === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="nome"
              value={nome}
              onChange={(e) => setNome(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="endereco">Endereço:{' '}
              {endereco === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="endereco"
              value={endereco}
              onChange={(e) => setEndereco(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="telefone">Telefone:{' '}
              {telefone === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="telefone"
              value={telefone}
              onChange={(e) => setTelefone(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="bairro">Bairro:{' '}
              {bairro === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="bairro"
              value={bairro}
              onChange={(e) => setBairro(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="cep">CEP:{' '}
              {cep === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
            <input
              type="text"
              id="cep"
              value={cep}
              onChange={(e) => setCep(e.target.value)}
              required
            />
          </div>
          <div className="modal-buttons">
            <button type="submit" className="btn-salvar" id="btn-salvar">
              {id ? 'Atualizar' : 'Salvar'}
            </button>
            <button type="button" className="btn-fechar" onClick={handleModalClose}>
              Fechar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ModalLocal;
