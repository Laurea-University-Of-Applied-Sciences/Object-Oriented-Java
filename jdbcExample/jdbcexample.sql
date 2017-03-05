
CREATE TABLE IF NOT EXISTS cars (
  plateNr varchar(10) NOT NULL,
  colour varchar(16) NOT NULL,
  model varchar(16) NOT NULL,
  year int(11) NOT NULL,
  PRIMARY KEY (plateNr)
);

INSERT INTO cars (plateNr, colour, model, year) VALUES
('HSR-367', 'Blue', 'Fiat', 1978),
('KJT-993', 'White', 'Toyota', 1993);
