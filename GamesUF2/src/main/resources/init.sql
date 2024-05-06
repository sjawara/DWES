/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  alumne_2n
 * Created: 18 de març 2024
 */

CREATE TABLE users(user_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
username VARCHAR(10) NOT NULL,
name VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
rank INT DEFAULT 0,
active BOOLEAN DEFAULT true,
created_on TIMESTAMP AS CURRENT_TIMESTAMP NOT NULL);
 
INSERT INTO users (username, name, email) VALUES ('user1', 'John Test', 'john@email.com');
INSERT INTO users (username, name, email) VALUES ('user2', 'Paul Test', 'paul@email.com');
