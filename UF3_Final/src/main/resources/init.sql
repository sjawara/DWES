/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  alumne_2n
 * Created: 18 de març 2024
 */

CREATE TABLE productos(id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
any INT,
nom VARCHAR(50) NOT NULL,
empresa VARCHAR(50) NOT NULL,
preu float(50) NOT NULL,
created_on TIMESTAMP AS CURRENT_TIMESTAMP NOT NULL);
 
INSERT INTO productos (any,nom,empresa,preu) VALUES (2020, 'FIFA 20', 'EA Sports',59.99);
INSERT INTO productos (any,nom,empresa,preu) VALUES (2021, 'FIFA 21', 'EA Sports',59.99);
