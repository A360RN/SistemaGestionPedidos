use ventas;

LOAD DATA
LOCAL INFILE 'C:/Users/ASUS/Desktop/PATRONES/SistemaGestionPedidos/dataCustomer.csv'
INTO TABLE Customer
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;