import React, { useState } from 'react';
import { Table, Space, Tag, Tooltip, Row, Col, Card, Modal, Button, Form, Input, Select, message } from 'antd';
import {
  UnlockOutlined,
  ClockCircleOutlined,
  CheckCircleOutlined,
} from '@ant-design/icons';

const { Column } = Table;
const { Option } = Select;

const PainelChave = () => {
  const [salas, setSalas] = useState([
    { id: 1, numerosala: 101, descricaosala: 'Sala de Reunião' },
    { id: 2, numerosala: 102, descricaosala: 'Sala de Treinamento' },
    // Outras salas fictícias...
  ]);
  const [chaves, setChaves] = useState([
    {
      id: 1,
      estado: 'Livre',
      salaId: 1,
      paroquiano: 'Paroquiano 1', // Adicione o nome do paroquiano aqui
      reserva: 'Reserva 1', // Adicione o nome da reserva aqui
    },
    {
      id: 2,
      estado: 'Aguardando Confirmação',
      salaId: 2,
      paroquiano: 'Paroquiano 2',
      reserva: 'Reserva 2',
    },
    // Outras chaves fictícias...
  ]);
  const [selectedSala, setSelectedSala] = useState(null);
  const [modalVisible, setModalVisible] = useState(false);

  const [form] = Form.useForm();

  const showModal = (sala) => {
    setSelectedSala(sala);
    setModalVisible(true);
  };

  const handleCancel = () => {
    setModalVisible(false);
  };

  const onFinish = (values) => {
    // Simulação de cadastro fictício
    message.success('Retirada cadastrada com sucesso!');
    setModalVisible(false);
    form.resetFields();
  };

  return (
    <div>
      <Row gutter={16}>
        {salas.map((sala) => (
          <Col key={sala.id} xs={24} sm={12} md={8} lg={6}>
            <Card
              title={`Sala ${sala.numerosala}`}
              style={{ marginBottom: '16px', cursor: 'pointer' }}
              onClick={() => showModal(sala)}
            >
              <p><b>Status da Chave:</b> {' '}
                {chaves.find((chave) => chave.salaId === sala.id)?.estado === 'Livre' && (
                  <Tag icon={<UnlockOutlined />} color="success">
                    Livre
                  </Tag>
                )}
                {chaves.find((chave) => chave.salaId === sala.id)?.estado === 'Aguardando Confirmação' && (
                  <Tag icon={<ClockCircleOutlined />} color="warning">
                    Aguardando Confirmação
                  </Tag>
                )}
                {chaves.find((chave) => chave.salaId === sala.id)?.estado === 'Ocupado' && (
                  <Tag icon={<CheckCircleOutlined />} color="error">
                    Ocupado
                  </Tag>
                )}
              </p>
              <p><b>Paroquiano:</b> {chaves.find((chave) => chave.salaId === sala.id)?.paroquiano}</p>
              <p><b>Reserva:</b> {chaves.find((chave) => chave.salaId === sala.id)?.reserva}</p>
            </Card>
          </Col>
        ))}
      </Row>
      <Modal
        title={`Detalhes da Sala ${selectedSala?.numerosala}`}
        visible={modalVisible}
        onCancel={handleCancel}
        footer={null}
      >
        <Form form={form} onFinish={onFinish}>
          <Form.Item
            name="chave"
            label="Chave"
            rules={[
              {
                required: true,
                message: 'Selecione uma chave',
              },
            ]}
          >
            <Select placeholder="Selecione uma chave">
              {chaves
                .filter((chave) => chave.salaId === selectedSala?.id)
                .map((chave) => (
                  <Option key={chave.id} value={chave.id}>
                    {chave.estado}
                  </Option>
                ))}
            </Select>
          </Form.Item>
          <Form.Item
            name="paroquiano"
            label="Paroquiano"
          >
            <Select placeholder="Selecione um paroquiano">
              <Option value="Paroquiano 1">Paroquiano 1</Option>
              <Option value="Paroquiano 2">Paroquiano 2</Option>
              {/* Adicione mais opções de paroquianos conforme necessário */}
            </Select>
          </Form.Item>
          <Form.Item
            name="reserva"
            label="Reserva"
          >
            <Select placeholder="Selecione uma reserva">
              <Option value="Reserva 1">Reserva 1</Option>
              <Option value="Reserva 2">Reserva 2</Option>
              {/* Adicione mais opções de reservas conforme necessário */}
            </Select>
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Cadastrar Retirada
            </Button>
          </Form.Item>
        </Form>
      </Modal>
    </div>
  );
};

export default PainelChave;
