
CREATE TABLE IF NOT EXISTS albums (
  id INT NOT NULL auto_increment,
  artist varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  available boolean NOT NULL DEFAULT 1,
  PRIMARY KEY (id)
);

INSERT INTO albums (artist, name) VALUES
('Bowie, David', 'Space Oddity'),
('Massive Attack', 'Heligoland'),
('Tool', 'Lateralus'),
('Morrissey', 'You Are the Quarry'),
('Morrissey', 'The Queen Is Dead');