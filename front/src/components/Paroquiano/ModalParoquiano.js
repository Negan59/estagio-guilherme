import React, { useState, useEffect } from 'react';
import axios from 'axios';

import '../../styles/formulario.css';

const ModalParoquiano = ({ paroquiano, onSubmit, onClose }) => {
  const [id, setId] = useState('');
  const [nome, setNome] = useState('');
  const [foto, setFoto] = useState('');
  const [telefone, setTelefone] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');

  useEffect(() => {
    if (paroquiano) {
      setId(paroquiano.id);
      setNome(paroquiano.nome);
      setFoto(paroquiano.foto);
      setTelefone(paroquiano.telefone);
      setEmail(paroquiano.email);
      setSenha(paroquiano.senha);
    }
  }, [paroquiano]);

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

    if (email === '') {
      setErro({ mensagem: 'Campo obrigatório: Email', sucesso: false });
      return;
    }

    let data = {};

    if (id) {
      data = {
        id: id,
        nome: nome,
        foto: foto,
        telefone: telefone,
        email: email,
        senha: senha,
      };
      // Atualização (Editar)
      axios
        .put(`http://localhost:8080/api/paroquiano`, data)
        .then((response) => {
          console.log('Dados atualizados com sucesso:', response.data);
          onSubmit(response.data);
          setId('');
          setNome('');
          setFoto('');
          setTelefone('');
          setEmail('');
          setSenha('');
          setErro('');
          onClose();
        })
        .catch((error) => {
          console.error('Erro ao atualizar os dados:', error);
          setErro({ mensagem: 'Erro ao atualizar o paroquiano. Por favor, tente novamente.', sucesso: false });
        });
    } else {
      data = {
        nome: nome,
        foto: foto,
        telefone: telefone,
        email: email,
        senha: senha,
      };
      // Inserção (Salvar)
      axios
        .post('http://localhost:8080/api/paroquiano', data)
        .then((response) => {
          console.log(response.data, response.data.status);
          if (response.data.status === 200) {
            setId('');
            setNome('');
            setFoto('');
            setTelefone('');
            setEmail('');
            setSenha('');
            setErro('');
            onClose();
          } else {
            setErro({ mensagem: 'Erro ao adicionar o paroquiano. Por favor, tente novamente.', sucesso: false });
          }
        })
        .catch((error) => {
          console.error('Erro ao salvar os dados:', error);
          setErro({ mensagem: 'Erro ao adicionar o paroquiano. Por favor, tente novamente.', sucesso: false });
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
        <h2>{id ? 'Editar Paroquiano' : 'Inserir Paroquiano'}</h2>
        {erro && <Erro mensagem={erro.mensagem} sucesso={erro.sucesso} />}
        <form onSubmit={handleSubmit} className="paroquiano-form">
          <div className="form-group">
            <label htmlFor="id">ID:</label>
            <input type="number" id="id" value={id} onChange={(e) => setId(e.target.value)} disabled />
          </div>
          <div className="form-group">
            <label htmlFor="nome">Nome:{' '}{nome === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="text" id="nome" value={nome} onChange={(e) => setNome(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="foto">Foto:{' '}{foto === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="text" id="foto" value={foto} onChange={(e) => setFoto(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="telefone">Telefone:{' '}{telefone === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="text" id="telefone" value={telefone} onChange={(e) => setTelefone(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email:{' '}{email === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="senha">Senha:{' '}{senha === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="password" id="senha" value={senha} onChange={(e) => setSenha(e.target.value)} required />
          </div>
          <div className="modal-buttons">
            <button type="submit" className="btn-salvar" id="btn-salvar">{id ? 'Atualizar' : 'Salvar'}</button>
            <button type="button" className="btn-fechar" onClick={handleModalClose}>Fechar</button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ModalParoquiano;
