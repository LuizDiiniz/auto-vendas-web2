-- Carga inicial para um banco novo. Dados e preços inteiramente fictícios.
BEGIN;
INSERT INTO tb_marca(nome,descricao,ativo) VALUES
('Toyota','Fabricante de veículos',true),('Volkswagen','Fabricante de veículos',true),
('Chevrolet','Fabricante de veículos',true),('Fiat','Fabricante de veículos',true),
('Honda','Fabricante de veículos',true),('Jeep','Fabricante de veículos',true),
('Marca desativada','Exemplo de fabricante inativo',false);
INSERT INTO tb_categoria(nome,categoria_id) VALUES ('Passeio',NULL),('Utilitários',NULL);
INSERT INTO tb_categoria(nome,categoria_id) SELECT n.nome,c.id FROM (VALUES ('Hatch'),('Sedã'),('SUV')) n(nome) CROSS JOIN tb_categoria c WHERE c.nome='Passeio';
INSERT INTO tb_categoria(nome,categoria_id) SELECT 'SUV compacto',id FROM tb_categoria WHERE nome='SUV';
INSERT INTO tb_categoria(nome,categoria_id) SELECT 'Picape',id FROM tb_categoria WHERE nome='Utilitários';
INSERT INTO tb_produto(nome,descricao,preco,quantidade_estoque,marca_id,categoria_id,ano_modelo,quilometragem,combustivel,cambio,cor)
SELECT d.nome,'Veículo demonstrativo. Dados fictícios para a atividade acadêmica.',d.preco,d.estoque,m.id,c.id,d.ano,d.km,d.combustivel,d.cambio,d.cor
FROM (VALUES
('Corolla XEi 2.0','Toyota','Sedã',132900.00,2,2023,32000,'FLEX','CVT','Prata'),
('Polo Highline 1.0 TSI','Volkswagen','Hatch',99900.00,3,2024,18000,'FLEX','AUTOMATICO','Branco'),
('Onix LT 1.0','Chevrolet','Hatch',72900.00,2,2022,45000,'FLEX','MANUAL','Preto'),
('Strada Freedom 1.3','Fiat','Picape',108900.00,1,2024,24000,'FLEX','MANUAL','Branco'),
('HR-V EX 1.5','Honda','SUV compacto',145900.00,1,2023,28000,'FLEX','CVT','Cinza'),
('Renegade Longitude 1.3','Jeep','SUV compacto',119900.00,2,2023,35000,'FLEX','AUTOMATICO','Azul')
) AS d(nome,marca,categoria,preco,estoque,ano,km,combustivel,cambio,cor)
JOIN tb_marca m ON m.nome=d.marca JOIN tb_categoria c ON c.nome=d.categoria;
COMMIT;
