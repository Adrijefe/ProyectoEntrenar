CREATE TABLE ListaJugadores (
                                ID_Lista INTEGER PRIMARY KEY AUTOINCREMENT,
                                NombreLista TEXT NOT NULL
);

CREATE TABLE Jugadores (
                           ID_Jugador INTEGER PRIMARY KEY AUTOINCREMENT,
                           Nombre TEXT NOT NULL,
                           País TEXT NOT NULL,
                           Títulos_Grand_Slam INTEGER NOT NULL,
                           Años_Actividad TEXT NOT NULL,
                           Imagen TEXT,
                           ID_Lista INTEGER NOT NULL,
                           FOREIGN KEY (ID_Lista) REFERENCES ListaJugadores(ID_Lista)
);
CREATE TABLE Torneos (
                         ID_Torneo INTEGER PRIMARY KEY AUTOINCREMENT,
                         NombreTorneo TEXT NOT NULL,
                         Año INTEGER NOT NULL,
                         Resultado TEXT NOT NULL,
                         ID_Jugador INTEGER NOT NULL,
                         FOREIGN KEY (ID_Jugador) REFERENCES Jugadores(ID_Jugador)
);

INSERT INTO Torneos (NombreTorneo, Año, Resultado, ID_Jugador) VALUES
                                                                   ('Wimbledon', 2003, 'Campeón', 1),  -- Roger Federer
                                                                   ('Roland Garros', 2008, 'Campeón', 2),  -- Rafael Nadal
                                                                   ('US Open', 2011, 'Finalista', 3),  -- Novak Djokovic
                                                                   ('Australian Open', 1969, 'Campeón', 4),  -- Rod Laver
                                                                   ('Roland Garros', 1974, 'Campeón', 5),  -- Björn Borg
                                                                   ('US Open', 1990, 'Finalista', 6),  -- Pete Sampras
                                                                   ('Wimbledon', 1992, 'Campeón', 7);  -- Andre Agassi



INSERT INTO ListaJugadores (NombreLista) VALUES ('Jugadores Tenis');

INSERT INTO Jugadores (Nombre, País, Títulos_Grand_Slam, Años_Actividad, Imagen, ID_Lista) VALUES
                                                                                               ('Roger Federer', 'Suiza', 20, '1998-2021', 'https://media.revistagq.com/photos/61522a221d29f507cd989f7a/16:9/w_2560,c_limit/GettyImages-1327542158.jpg', 1),
                                                                                               ('Rafael Nadal', 'España', 22, '2001-presente', 'https://www.centrosenlinea.com/wp-content/uploads/2021/03/Rafa-Nadal-foto-portada.jpg', 1),
                                                                                               ('Novak Djokovic', 'Serbia', 24, '2003-presente', 'https://images.pagina12.com.ar/styles/focal_3_2_470x313/public/2024-07/854290-novak-20afp.jpg?h=ada05aa9&itok=pyLPtxn6', 1),
                                                                                               ('Rod Laver', 'Australia', 11, '1962-1979', 'https://media.gettyimages.com/id/1496897977/es/foto/australian-tennis-player-rod-laver-in-action-during-the-final-of-the-mens-singles-tournament.jpg?s=612x612&w=gi&k=20&c=af7AN8DhsIgXOMfZIKSRdxjSBPasH-2AtIf3t_vN8QY=', 1),
                                                                                               ('Björn Borg', 'Suecia', 11, '1973-1983', 'https://cdn.artphotolimited.com/images/5b9fc1ecac06024957be8806/1000x1000/bjorn-borg-en-pleine-concentration.jpg', 1),
                                                                                               ('Pete Sampras', 'Estados Unidos', 14, '1988-2002', 'https://canaltenis.com/wp-content/uploads/2020/08/pete.jpg', 1),
                                                                                               ('Andre Agassi', 'Estados Unidos', 8, '1986-2006', 'https://estaticos-cdn.prensaiberica.es/clip/801723aa-7531-45b8-bdff-a83b690c4bf3_alta-libre-aspect-ratio_default_0.jpg', 1);
