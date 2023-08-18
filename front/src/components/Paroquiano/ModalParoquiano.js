import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'react-phone-number-input/style.css';
import PhoneInput from 'react-phone-number-input';

import '../../styles/formulario.css';

const ModalParoquiano = ({ paroquiano, onSubmit, onClose }) => {
  const [id, setId] = useState('');
  const [nome, setNome] = useState('');
  const [foto, setFoto] = useState('');
  const [telefone, setTelefone] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [confirmarSenha, setConfirmarSenha] = useState('');
  const [telefoneErro, setTelefoneErro] = useState(false);
  const [erro, setErro] = useState('');

  useEffect(() => {
    if (paroquiano) {
      setId(paroquiano.id);
      setNome(paroquiano.nome);
      setFoto(paroquiano.foto);
      setTelefone(paroquiano.telefone);
      setEmail(paroquiano.email);
    }
  }, [paroquiano]);

  const handleSubmit = (event) => {
    event.preventDefault();

    if (nome === '') {
      setErro('Campo obrigatório: Nome');
      return;
    }

    if (email === '') {
      setErro('Campo obrigatório: Email');
      return;
    }

    if (!validateTelefone(telefone)) {
      setTelefoneErro(true);
      return;
    }

    if (senha === '' || senha.length < 6) {
      setErro('Senha inválida (mínimo 6 caracteres)');
      return;
    }

    if (senha !== confirmarSenha) {
      setErro('As senhas não coincidem');
      return;
    }

    let data = {
      nome: nome,
      foto: foto,
      telefone: telefone,
      email: email,
      senha: senha,
    };

    if (id) {
      data.id = id;

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
          setErro('Erro ao atualizar o paroquiano. Por favor, tente novamente.');
        });
    } else {
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
            setErro('Erro ao adicionar o paroquiano. Por favor, tente novamente.');
          }
        })
        .catch((error) => {
          console.error(error);
          setErro('Erro ao adicionar o paroquiano. Por favor, tente novamente.');
        });
    }
  };

  const validateTelefone = (value) => {
    const telefoneDigits = value.replace(/\D/g, ''); // Remover caracteres não numéricos
    const telefoneLength = telefoneDigits.length;

    // No Brasil, os números de telefone fixo têm 10 dígitos e os celulares têm 11 dígitos
    return telefoneLength === 12 || telefoneLength === 13;
  };

  const handleModalContentClick = (event) => {
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
        {erro && <div className="mensagem-fracasso">{erro}</div>}
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
            <label htmlFor="telefone">Telefone:{' '}
              <PhoneInput
                defaultCountry="BR"
                placeholder="Insira o número de telefone"
                value={telefone}
                onChange={setTelefone}
                required
              />
              {telefoneErro && <span className="erro">Telefone inválido</span>}
              {telefone === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
          </div>
          <div className="form-group">
            <label htmlFor="email">Email:{' '}{email === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="senha">Senha:{' '}{senha === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="password" id="senha" value={senha} onChange={(e) => setSenha(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="confirmarSenha">Confirmar Senha:{' '}{confirmarSenha === '' && <span className="campo-obrigatorio">* Obrigatório</span>}</label>
            <input type="password" id="confirmarSenha" value={confirmarSenha} onChange={(e) => setConfirmarSenha(e.target.value)} required />
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
