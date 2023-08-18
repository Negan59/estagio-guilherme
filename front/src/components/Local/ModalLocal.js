import React, { useState, useEffect } from 'react';
import axios from 'axios';
import InputMask from 'react-input-mask';
import PhoneInput from 'react-phone-number-input';
import 'react-phone-number-input/style.css';

import '../../styles/formulario.css';

const ModalLocal = ({ local, onSubmit, onClose }) => {
  const [id, setId] = useState('');
  const [nome, setNome] = useState('');
  const [endereco, setEndereco] = useState('');
  const [telefone, setTelefone] = useState('');
  const [cep, setCep] = useState('');
  const [bairro, setBairro] = useState('');
  const [telefoneErro, setTelefoneErro] = useState(false);
  const [cepErro, setCepErro] = useState(false);
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

  const validateTelefone = (value) => {
    const telefoneDigits = value.replace(/\D/g, ''); // Remover caracteres não numéricos
    const telefoneLength = telefoneDigits.length;

    // No Brasil, os números de telefone fixo têm 10 dígitos e os celulares têm 11 dígitos
    return telefoneLength === 12 || telefoneLength === 13;
  };

  const validateCep = (value) => {
    const cepRegex = /^\d{5}-\d{3}$/;
    return cepRegex.test(value);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    setErro('');

    if (!validateTelefone(telefone)) {
      setTelefoneErro(true);
      return;
    }

    if (!validateCep(cep)) {
      setCepErro(true);
      return;
    }

    let data = {
      nome: nome,
      endereco: endereco,
      telefone: telefone,
      bairro: bairro,
      cep: cep,
    };

    try {
      if (id) {
        data.id = id;
        await axios.put(`http://localhost:8080/api/local`, data);
      } else {
        await axios.post('http://localhost:8080/api/local', data);
      }

      console.log('Dados salvos com sucesso');
      if (onSubmit) {
        onSubmit(data);
      }
      setId('');
      setNome('');
      setEndereco('');
      setTelefone('');
      setBairro('');
      setCep('');
      setErro('');
      onClose();
    } catch (error) {
      console.error('Erro ao salvar os dados:', error);
      setErro('Erro ao salvar o local. Por favor, tente novamente.');
    }
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
        <h2>{id ? 'Editar Local' : 'Inserir Local'}</h2>
        {erro && <div className="mensagem-fracasso">{erro}</div>}
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
              <InputMask
                mask="99999-999"
                placeholder="12345-678"
                value={cep}
                onChange={(e) => setCep(e.target.value)}
                required
              />
              {cepErro && <span className="erro">CEP inválido</span>}
              {cep === '' && <span className="campo-obrigatorio">* Obrigatório</span>}
            </label>
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
