SELECT v.placa, v.estado, v.cidade
FROM Veiculos v
JOIN Responsaveis r ON v.responsavel_id = r.id
WHERE r.nome = 'Joaquim Silva';