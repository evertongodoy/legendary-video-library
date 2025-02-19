db = db.getSiblingDB('librarydb');

db.createUser({
  user: "library",
  pwd: "library",
  roles: [{ role: "readWrite", db: "librarydb" }]
});

db.createCollection("legendary_library");

db.legendary_library.insertMany([
  {
      nome: "Noite Sombria",
      genero: "Horror",
      duracao: 120,
      origem: "EUA",
      lancamento: ISODate("2023-02-15T00:00:00Z"),
      sinopse: "Um grupo de amigos se aventura em uma casa assombrada.",
      atores: ["Ethan Hawke", "Scarlett Johansson", "James McAvoy"],
      diretor: "Wes Craven",
      classificacao: 18
    },
    {
      nome: "A Jornada Intergaláctica",
      genero: "Ficção Científica",
      duracao: 145,
      origem: "Reino Unido",
      lancamento: ISODate("2022-07-10T00:00:00Z"),
      sinopse: "Uma tripulação embarca em uma missão para salvar a Terra.",
      atores: ["Chris Pratt", "Zoe Saldana", "Benedict Cumberbatch"],
      diretor: "Ridley Scott",
      classificacao: 12
    },
    {
      nome: "O Assalto Perfeito",
      genero: "Ação",
      duracao: 130,
      origem: "França",
      lancamento: ISODate("2023-09-20T00:00:00Z"),
      sinopse: "Um grupo de ladrões planeja o roubo mais audacioso da história.",
      atores: ["Matt Damon", "Angelina Jolie", "Ryan Reynolds"],
      diretor: "Christopher Nolan",
      classificacao: 16
    },
    {
      nome: "O Romance de Paris",
      genero: "Romance",
      duracao: 110,
      origem: "França",
      lancamento: ISODate("2022-04-05T00:00:00Z"),
      sinopse: "Um escritor encontra o amor inesperado em Paris.",
      atores: ["Anne Hathaway", "Timothée Chalamet", "Emma Stone"],
      diretor: "Richard Curtis",
      classificacao: 14
    },
    {
      nome: "No Limite da Mente",
      genero: "Thriller Psicológico",
      duracao: 125,
      origem: "Canadá",
      lancamento: ISODate("2024-01-11T00:00:00Z"),
      sinopse: "Um psicólogo descobre que seus pacientes compartilham memórias idênticas.",
      atores: ["Jake Gyllenhaal", "Jessica Chastain", "Edward Norton"],
      diretor: "David Fincher",
      classificacao: 16
    },
    {
      nome: "A Lenda do Samurai",
      genero: "Aventura",
      duracao: 140,
      origem: "Japão",
      lancamento: ISODate("2021-12-18T00:00:00Z"),
      sinopse: "Um guerreiro samurai busca vingança contra seu antigo mestre.",
      atores: ["Ken Watanabe", "Takeshi Kitano", "Hiroyuki Sanada"],
      diretor: "Akira Kurosawa Jr.",
      classificacao: 14
    },
    {
      nome: "Mundos Paralelos",
      genero: "Fantasia",
      duracao: 135,
      origem: "Alemanha",
      lancamento: ISODate("2023-06-22T00:00:00Z"),
      sinopse: "Uma jovem descobre um portal para um mundo mágico e desconhecido.",
      atores: ["Tom Hiddleston", "Natalie Portman", "Mads Mikkelsen"],
      diretor: "Guillermo del Toro",
      classificacao: 12
    },
    {
      nome: "Operação Alfa",
      genero: "Espionagem",
      duracao: 132,
      origem: "Rússia",
      lancamento: ISODate("2023-08-10T00:00:00Z"),
      sinopse: "Um espião russo tenta impedir um ataque nuclear.",
      atores: ["Daniel Craig", "Charlize Theron", "Idris Elba"],
      diretor: "Sam Mendes",
      classificacao: 16
    },
    {
      nome: "Corrida Mortal",
      genero: "Ação",
      duracao: 125,
      origem: "Brasil",
      lancamento: ISODate("2022-10-15T00:00:00Z"),
      sinopse: "Pilotos de corrida competem em uma prova ilegal de alta velocidade.",
      atores: ["Vin Diesel", "Michelle Rodriguez", "Wagner Moura"],
      diretor: "Justin Lin",
      classificacao: 14
    },
    {
      nome: "O Último Refúgio",
      genero: "Drama",
      duracao: 118,
      origem: "Argentina",
      lancamento: ISODate("2023-11-07T00:00:00Z"),
      sinopse: "Uma família luta para sobreviver em um mundo devastado pela guerra.",
      atores: ["Leonardo DiCaprio", "Cate Blanchett", "Javier Bardem"],
      diretor: "Alejandro González Iñárritu",
      classificacao: 14
    },
    {
      nome: "Código Mortal",
      genero: "Mistério",
      duracao: 130,
      origem: "Itália",
      lancamento: ISODate("2021-09-23T00:00:00Z"),
      sinopse: "Um detetive desvenda um código que pode mudar a história da humanidade.",
      atores: ["Robert Downey Jr.", "Rachel Weisz", "Mark Ruffalo"],
      diretor: "Denis Villeneuve",
      classificacao: 16
    },
    {
      nome: "As Sombras do Passado",
      genero: "Terror",
      duracao: 122,
      origem: "Espanha",
      lancamento: ISODate("2023-05-14T00:00:00Z"),
      sinopse: "Uma mulher se muda para uma casa onde os antigos moradores desapareceram.",
      atores: ["Anya Taylor-Joy", "Javier Gutiérrez", "Penélope Cruz"],
      diretor: "James Wan",
      classificacao: 18
    },
    {
        nome: "O Chamado do Abismo",
        genero: "Terror",
        duracao: 128,
        origem: "México",
        lancamento: ISODate("2022-03-10T00:00:00Z"),
        sinopse: "Um mergulhador descobre uma caverna subaquática habitada por entidades sombrias.",
        atores: ["Gael García Bernal", "Salma Hayek", "Diego Luna"],
        diretor: "Guillermo del Toro",
        classificacao: 18
      },
      {
        nome: "Inferno de Aço",
        genero: "Guerra",
        duracao: 140,
        origem: "Alemanha",
        lancamento: ISODate("2021-11-01T00:00:00Z"),
        sinopse: "Uma tropa de soldados enfrenta desafios extremos durante a Segunda Guerra Mundial.",
        atores: ["Brad Pitt", "Michael Fassbender", "Tom Hardy"],
        diretor: "Quentin Tarantino",
        classificacao: 16
      },
      {
        nome: "Circuito Fechado",
        genero: "Suspense",
        duracao: 120,
        origem: "Austrália",
        lancamento: ISODate("2023-07-19T00:00:00Z"),
        sinopse: "Um hacker descobre um sistema de vigilância global que pode controlar a mente das pessoas.",
        atores: ["Hugh Jackman", "Margot Robbie", "Sam Worthington"],
        diretor: "Christopher Nolan",
        classificacao: 14
      },
      {
        nome: "O Último Gladiador",
        genero: "Épico",
        duracao: 150,
        origem: "Itália",
        lancamento: ISODate("2022-12-05T00:00:00Z"),
        sinopse: "A história de um gladiador que desafia um império para conquistar sua liberdade.",
        atores: ["Russell Crowe", "Gerard Butler", "Monica Bellucci"],
        diretor: "Ridley Scott",
        classificacao: 16
      },
      {
        nome: "Universo Paralelo",
        genero: "Ficção Científica",
        duracao: 138,
        origem: "China",
        lancamento: ISODate("2024-01-25T00:00:00Z"),
        sinopse: "Cientistas descobrem um portal para uma dimensão alternativa e tentam explorá-lo.",
        atores: ["Simu Liu", "Tony Leung", "Awkwafina"],
        diretor: "Denis Villeneuve",
        classificacao: 12
      },
      {
        nome: "O Código da Máfia",
        genero: "Crime",
        duracao: 130,
        origem: "EUA",
        lancamento: ISODate("2023-09-08T00:00:00Z"),
        sinopse: "Um jovem é recrutado para uma família mafiosa e precisa provar sua lealdade.",
        atores: ["Al Pacino", "Robert De Niro", "Joe Pesci"],
        diretor: "Martin Scorsese",
        classificacao: 18
      },
      {
        nome: "Corrida Contra o Tempo",
        genero: "Ação",
        duracao: 115,
        origem: "Coreia do Sul",
        lancamento: ISODate("2023-04-30T00:00:00Z"),
        sinopse: "Um detetive tem apenas 24 horas para impedir um atentado terrorista.",
        atores: ["Lee Byung-hun", "Ma Dong-seok", "Jun Ji-hyun"],
        diretor: "Park Chan-wook",
        classificacao: 16
      },
      {
        nome: "A Ilha dos Esquecidos",
        genero: "Aventura",
        duracao: 125,
        origem: "Filipinas",
        lancamento: ISODate("2023-06-18T00:00:00Z"),
        sinopse: "Exploradores descobrem uma ilha perdida onde o tempo parece estar congelado.",
        atores: ["Dwayne Johnson", "Gal Gadot", "Chris Hemsworth"],
        diretor: "James Cameron",
        classificacao: 12
      }
]);