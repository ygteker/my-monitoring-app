DROP TABLE IF EXISTS servers;

CREATE TABLE servers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  server_name VARCHAR(250) NOT NULL,
  server_address VARCHAR(255) NOT NULL,
  added_at DATETIME DEFAULT NOW()
);

INSERT INTO servers (server_name, server_address) VALUES
  ('google', 'www.google.com');