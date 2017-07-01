use ventas;

LOAD DATA
LOCAL INFILE 'C:/Users/ASUS/Desktop/PATRONES/SistemaGestionPedidos/dataCustomer.csv'
INTO TABLE Customer
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

LOAD DATA
LOCAL INFILE 'C:/Users/ASUS/Desktop/PATRONES/SistemaGestionPedidos/categoria.csv'
INTO TABLE category
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

LOAD DATA
LOCAL INFILE 'C:/Users/ASUS/Desktop/PATRONES/SistemaGestionPedidos/producto.csv'
INTO TABLE product
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;

LOAD DATA
LOCAL INFILE 'C:/Users/ASUS/Desktop/PATRONES/SistemaGestionPedidos/productoCategoria.csv'
INTO TABLE productcategory
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES;