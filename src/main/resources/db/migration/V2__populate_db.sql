INSERT INTO Client
(name)
VALUES
     ('Antoni'),
     ('David'),
     ('Andi'),
     ('Meri'),
     ('Julia'),
     ('Simon'),
     ('Jerry'),
     ('Jack'),
     ('Denis'),
     ('Catherine');

INSERT INTO Planet
(id, name)
VALUES
     ('MARS', 'Mars'),
     ('VEN', 'Venus'),
     ('EARTH', 'Earth'),
     ('MERC', 'Mercury'),
     ('JUP', 'Jupiter');

INSERT INTO Ticket
(client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'EARTH', 'MERC'),
    (2, 'VEN', 'MARS'),
    (3, 'EARTH', 'VEN'),
    (4, 'MARS', 'EARTH'),
    (5, 'EARTH', 'JUP'),
    (6, 'JUP', 'VEN'),
    (7, 'VEN', 'EARTH'),
    (8, 'JUP', 'EARTH'),
    (9, 'MERC', 'JUP'),
    (10, 'JUP', 'MARS');

