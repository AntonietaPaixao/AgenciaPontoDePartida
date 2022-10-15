Algoritmo "AGENCIA_PONTO_DE_PARTIDA - CLIENTE"

// Descrição   : Agencia de viagens voltada para partidas de futebol, no território nacional
// Autor(a)    : Mª Antonieta Paixão
// Data atual  : 01/06/2022

Var

  //VARIÁVEIS DO PACOTE
  cadastroPacote: vetor[1..20,1..9] de caracter
  cidadePartida, time1, time2: caracter
  ultimoPacote: inteiro

  //VARIÁVEIS DO CLIENTE
  cadastroCliente: vetor[1..20,1..8] de caracter
  nomeCliente, cpfCliente, cidadeCliente: caracter
  ultimoCliente: inteiro

  //VARIÁVEIS DE CONTROLE
  resposta1, repetePacote, repeteCliente: inteiro
  enter: caracter

  //PROCEDIMENTO PARATELA*******************************************************
  procedimento paraTela
  inicio
    escreval("")
    escreva("Pressione ENTER para continuar...")
    leia(enter)
    limpatela
  fimprocedimento

  //PROCEDIMENTO LISTAPACOTES***************************************************
  procedimento listaPacotes(ini, fim: inteiro)
   var
    l, c: inteiro
   inicio
    c <-1
    para l de ini ate fim faca
      escreval("")
      escreva("PACOTE", l, ":")
      para c de 1 ate 9 faca
        escolha (c)
          caso 1
            escreva("Partida do Campeonato ", cadastroPacote[l,c])
          caso 2
            escreva(", entre ", cadastroPacote[l,c], " e ")
          caso 3
            escreval(cadastroPacote[l,c], ".")
          caso 4
            escreva("Ocorrerá na cidade de ", cadastroPacote[l,c], "-")
          caso 5
            escreva(cadastroPacote[l,c])
          caso 6
            escreval(", no dia ", cadastroPacote[l,c], ",")
          caso 7
            escreva("partindo da cidade de ", cadastroPacote[l,c], "-")
          caso 8
            escreva(cadastroPacote[l,c], ".")
          caso 9
            escreval("")
            escreval("Valor do Pacote: R$", cadastroPacote[l,c], ".")
        fimescolha
        c <- c+1
      fimpara
      l <- l+1
    fimpara
  fimprocedimento

  //PROCEDIMENTO LISTACLIENTES***************************************************
  procedimento listaClientes(ini, fim: inteiro)
   var
    l, c: inteiro
   inicio
    c <-1
    para l de ini ate fim faca
      escreval("")
      escreva("CLIENTE", l, ": ")
      para c de 1 ate 8 faca
        escolha (c)
          caso 1
            escreval(cadastroCliente[l,c])
          caso 2
            escreval("CPF: ", cadastroCliente[l,c])
          caso 3
            escreval("Data de Nascimento: ", cadastroCliente[l,c], ".")
          caso 4
            escreval("Sexo: ", cadastroCliente[l,c],)
          caso 5
            escreval("Celular: ", cadastroCliente[l,c])
          caso 6
            escreva("Cidade: ", cadastroCliente[l,c])
          caso 7
            escreval("-", cadastroCliente[l,c], ".")
          caso 8
            escreval("Torcedor do ", cadastroCliente[l,c], ".")
        fimescolha
        c <- c+1
      fimpara
      l <- l+1
    fimpara
  fimprocedimento

  //PROCEDIMENTO CADASTRA PACOTES***********************************************
  procedimento cadastraPacotes
  var
    time1, time2, cidadePartida: caracter
    //Var de Controle
    resp2, lin: inteiro
    resp1: caracter

  inicio

    escreval("USUÁRIO ADMINISTRADOR")
    escreval("-------------------------------------------------")
    escreval("|           AGENCIA PONTO DE PARTIDA            |")
    escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
    escreval("-------------------------------------------------")
    escreval("|               CADASTRO DE PACOTES             |")
    escreval("-------------------------------------------------")
    escreval("")
    
    resp1 <- "S"
    enquanto resp1= "S" faca
      lin <- ultimoPacote +1
      resp2 <- 0
      repita
        escreval("DIGITE AS INFORMAÇÕES DO ", lin, "º PACOTE.")
        escreval("")
        escreval(">>> INFORME O CAMPEONATO:")
        escreval("    1-Brasileirão  | 2-Campeonato Brasileiro")
        escreva("    3-Libertadores | 4-Estadual: ")
        leia(resp2)

        escolha resp2
          caso 1
            cadastroPacote[lin,1] <- "Brasileirão"
          caso 2
            cadastroPacote[lin,1] <- "Brasileiro"
          caso 3
            cadastroPacote[lin,1] <- "Libertadores"
          caso 4
            cadastroPacote[lin,1] <- "Estadual"
          outrocaso
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|               CADASTRO DE PACOTES             |")
            escreval("-------------------------------------------------")
            escreval("OPÇÃO INVÁLIDA - DIGITE UM VALOR ENTE 1 E 4")

            resp2 <-0
        fimescolha
      ate((resp2 >= 1) e (resp2 <= 4))

      escreva(">>> INFORME O TIME 1: ")
      leia (time1)
      cadastroPacote[lin,2] <- maiusc(time1)
      escreva(">>> INFORME O TIME 2: ")
      leia (time2)
      cadastroPacote[lin,3] <- maiusc(time2)
      escreva(">>> INFORME A CIDADE QUE CEDIARÁ A PARTIDA: ")
      leia (cidadePartida)
      cadastroPacote[lin,4] <- maiusc(cidadePartida)
      escreva(">>> ESTADO(UF): ")
      leia (cadastroPacote[lin,5])
      escreva(">>> DATA DA PARTIDA: ")
      leia (cadastroPacote[lin,6])
      escreva(">>> CIDADE DE ORIGEM: ")
      leia (cadastroPacote[lin,7])
      escreva(">>> ESTADO: ")
      leia (cadastroPacote[lin,8])
      escreva(">>> VALOR DO PACOTE: ")
      leia (cadastroPacote[lin,9])

      ultimoPacote <- ultimoPacote +1
      paraTela

      escreval("USUÁRIO ADMINISTRADOR")
      escreval("-------------------------------------------------")
      escreval("|           AGENCIA PONTO DE PARTIDA            |")
      escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
      escreval("-------------------------------------------------")
      escreval("|               CADASTRO DE PACOTES             |")
      escreval("-------------------------------------------------")
      escreval("CADASTRADO REALIZADO COM SUCESSO!")

      repita
        escreval("")
        escreva("DESEJA CADASTRAR MAIS ALGUM PACOTE? S/N  ")
        leia (resp1)
        resp1 <- maiusc(resp1)
        escolha resp1
          caso "S"
            resp1 <- "S"
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|               CADASTRO DE PACOTES             |")
            escreval("-------------------------------------------------")
            escreval("")
            
          caso "N"
            resp1 <- "N"
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|                    MENU                       |")
            escreval("-------------------------------------------------")
            escreval("")
            
          outrocaso
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|               CADASTRO DE PACOTES             |")
            escreval("-------------------------------------------------")
            escreval("OPÇÃO INVÁLIDA - DIGITE S PARA SIM E N PARA NÃO")

        fimescolha
      ate ((resp1 = "S") ou (resp1 = "N"))

    fimenquanto

  fimprocedimento

  //PROCEDIMENTO CADASTRA CLIENTE***********************************************
  procedimento cadastraClientes
  var
    nomeCliente, cpf, time, cidade: caracter
    //Var de Controle
    lin: inteiro
    resp1: caracter

  inicio

    escreval("USUÁRIO ADMINISTRADOR")
    escreval("-------------------------------------------------")
    escreval("|           AGENCIA PONTO DE PARTIDA            |")
    escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
    escreval("-------------------------------------------------")
    escreval("|               CADASTRO DE CLIENTES            |")
    escreval("-------------------------------------------------")
    escreval("")
    
    resp1 <- "S"
    enquanto resp1= "S" faca
      lin <- ultimoCliente +1

      escreval("DIGITE AS INFORMAÇÕES DO ", lin, "º CLIENTE.")
      escreval("")
      escreva(">>> NOME: ")
      leia (nomeCliente)
      cadastroCliente[lin,1] <- maiusc(nomeCliente)
      escreva(">>> CPF: ")
      leia (cadastroCliente[lin,2])
      escreva(">>> DATA DE NASCIMENTO: ")
      leia (cadastroCliente[lin,3])
      escreva(">>> SEXO: ")
      leia (cadastroCliente[lin,4])
      escreva(">>> CELULAR: ")
      leia (cadastroCliente[lin,5])
      escreva(">>> CIDADE DE RESIDENCIA: ")
      leia (cadastroCliente[lin,6])
      escreva(">>> ESTADO(UF): ")
      leia (cadastroCliente[lin,7])
      escreva(">>> TIME DE CORAÇÃO: ")
      leia (cadastroCliente[lin,8])

      ultimoCliente <- ultimoCliente +1
      paraTela

      escreval("USUÁRIO ADMINISTRADOR")
      escreval("-------------------------------------------------")
      escreval("|           AGENCIA PONTO DE PARTIDA            |")
      escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
      escreval("-------------------------------------------------")
      escreval("|               CADASTRO DE CLIENTES            |")
      escreval("-------------------------------------------------")
      escreval("CADASTRADO REALIZADO COM SUCESSO!")

      listaClientes(lin,lin)

      repita
        escreval("")
        escreva("DESEJA CADASTRAR MAIS ALGUM CLIENTE? S/N  ")
        leia (resp1)
        resp1 <- maiusc(resp1)
        escolha resp1
          caso "S"
            resp1 <- "S"
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|               CADASTRO DE CLIENTES            |")
            escreval("-------------------------------------------------")
            escreval("")

          caso "N"
            resp1 <- "N"
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|                    MENU                       |")
            escreval("-------------------------------------------------")
            escreval("")

          outrocaso
            limpatela
            escreval("USUÁRIO ADMINISTRADOR")
            escreval("-------------------------------------------------")
            escreval("|           AGENCIA PONTO DE PARTIDA            |")
            escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
            escreval("-------------------------------------------------")
            escreval("|               CADASTRO DE CLIENTES            |")
            escreval("-------------------------------------------------")
            escreval("OPÇÃO INVÁLIDA - DIGITE S PARA SIM E N PARA NÃO")

        fimescolha
      ate ((resp1 = "S") ou (resp1 = "N"))

    fimenquanto

  fimprocedimento

  //INICIO PROCEDIMENTO CONSULTA PACOTES****************************************
  procedimento consultaPacotes
  var
    pesqPacote: caracter
    quantPacote, resp1, repetePacote, l, c: inteiro

  inicio
    se ultimoPacote = 0 entao
      escreval("USUÁRIO ADMINISTRADOR")
      escreval("-------------------------------------------------")
      escreval("|           AGENCIA PONTO DE PARTIDA            |")
      escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
      escreval("-------------------------------------------------")
      escreval("|              CONSULTA DE PACOTES              |")
      escreval("-------------------------------------------------")
      escreval("AINDA NÃO FORAM CADASTRADOS PACOTES!")
      paraTela
      escreval("USUÁRIO ADMINISTRADOR")
      escreval("-------------------------------------------------")
      escreval("|           AGENCIA PONTO DE PARTIDA            |")
      escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
      escreval("-------------------------------------------------")
      escreval("|                      MENU                     |")
      escreval("-------------------------------------------------")
      escreval("")
    senao
      resp1 <-0
      repita
        escreval("USUÁRIO ADMINISTRADOR")
        escreval("-------------------------------------------------")
        escreval("|           AGENCIA PONTO DE PARTIDA            |")
        escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
        escreval("-------------------------------------------------")
        escreval("|              CONSULTA DE PACOTES              |")
        escreval("-------------------------------------------------")
        escreval("")
        escreval("               ESCOLHA UMA OPÇÃO:")
        escreval("")
        escreval(" 1 Para listar os pacotes cadastrados no sistema.")
        escreval(" 2 Para consultar um pacote específico.")
        escreval(" 3 Para sair da tela de consulta.")
        leia (resp1)

        se resp1 = 3 entao
          limpatela
          escreval("USUÁRIO ADMINISTRADOR")
          escreval("-------------------------------------------------")
          escreval("|           AGENCIA PONTO DE PARTIDA            |")
          escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
          escreval("-------------------------------------------------")
          escreval("|                      MENU                     |")
          escreval("-------------------------------------------------")
          escreval("")
        senao
            se resp1=1 entao
              limpatela
              escreval("USUÁRIO ADMINISTRADOR")
              escreval("-------------------------------------------------")
              escreval("|           AGENCIA PONTO DE PARTIDA            |")
              escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
              escreval("-------------------------------------------------")
              escreval("|              CONSULTA DE PACOTES              |")
              escreval("-------------------------------------------------")
              escreval("ESTES SÃO OS PACOTES EXISTENTES NO SISTEMA:")
              listaPacotes(1, ultimoPacote)
              paraTela
              resp1 <-0
            senao
              se resp1=2 entao
                limpatela
                escreval("USUÁRIO ADMINISTRADOR")
                escreval("-------------------------------------------------")
                escreval("|           AGENCIA PONTO DE PARTIDA            |")
                escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                escreval("-------------------------------------------------")
                escreval("|              CONSULTA DE PACOTES              |")
                escreval("-------------------------------------------------")
                escreval("             PESQUISE PACOTES PELO:             ")
                escreval("   TIME PARTICIPANTE OU CIDADE SEDE DA PARTIDA  ")

                leia(pesqPacote)
                pesqPacote <- maiusc(pesqPacote)
                limpatela

                quantPacote <- 0
                para l de 1 ate ultimoPacote faca
                  repetePacote <- 0
                    para c de 2 ate 4 faca
                      se((pesqPacote = cadastroPacote[l,c]) e (repetePacote < 1 )) entao
                        repetePacote <- repetePacote +1
                        quantPacote <-quantPacote +1
                      fimse
                    fimpara
                fimpara

                se quantPacote=0 entao
                  escreval("USUÁRIO ADMINISTRADOR")
                  escreval("-------------------------------------------------")
                  escreval("|           AGENCIA PONTO DE PARTIDA            |")
                  escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                  escreval("-------------------------------------------------")
                  escreval("|              CONSULTA DE PACOTES              |")
                  escreval("-------------------------------------------------")
                  escreval("NENHUM RESULTADO ENCONTRADO PARA A PESQUISA!")
                senao
                  escreval("USUÁRIO ADMINISTRADOR")
                  escreval("-------------------------------------------------")
                  escreval("|           AGENCIA PONTO DE PARTIDA            |")
                  escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                  escreval("-------------------------------------------------")
                  escreval("|              CONSULTA DE PACOTES              |")
                  escreval("-------------------------------------------------")
                  escreval("PACOTES ENCONTRADOS: ", quantPacote)
                    para l de 1 ate ultimoPacote faca
                      repetePacote <- 0
                        para c de 2 ate 4 faca
                          se((pesqPacote = cadastroPacote[l,c]) e (repetePacote < 1 )) entao
                              listaPacotes(l,l)
                              repetePacote <- repetePacote +1
                          fimse
                        fimpara
                    fimpara
                fimse
                paraTela
                resp1 <-0
              senao
                limpatela
                escreval("USUÁRIO ADMINISTRADOR")
                escreval("-------------------------------------------------")
                escreval("|           AGENCIA PONTO DE PARTIDA            |")
                escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                escreval("-------------------------------------------------")
                escreval("|              CONSULTA DE PACOTES              |")
                escreval("-------------------------------------------------")
                escreval("OPÇÃO INVÁLIDA - DIGITE UM VALOR ENTE 1 E 3")
                paraTela
              fimse
            fimse
        fimse
      ate((resp1=1) ou (resp1= 2) ou (resp1=3))
    fimse
  fimprocedimento


//INICIO PROCEDIMENTO CONSULTA CLIENTES****************************************
  procedimento consultaClientes
  var
    pesqCliente: caracter
    quantCliente, resp1, repeteCliente, l, c: inteiro

  inicio
    se ultimoCliente = 0 entao
      escreval("USUÁRIO ADMINISTRADOR")
      escreval("-------------------------------------------------")
      escreval("|           AGENCIA PONTO DE PARTIDA            |")
      escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
      escreval("-------------------------------------------------")
      escreval("|              CONSULTA DE CLIENTES             |")
      escreval("-------------------------------------------------")
      escreval("AINDA NÃO FORAM CADASTRADOS CLIENTES!")
      paraTela
      escreval("USUÁRIO ADMINISTRADOR")
      escreval("-------------------------------------------------")
      escreval("|           AGENCIA PONTO DE PARTIDA            |")
      escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
      escreval("-------------------------------------------------")
      escreval("|                      MENU                     |")
      escreval("-------------------------------------------------")
      escreval("")
    senao
      resp1 <-0
      repita
        escreval("USUÁRIO ADMINISTRADOR")
        escreval("-------------------------------------------------")
        escreval("|           AGENCIA PONTO DE PARTIDA            |")
        escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
        escreval("-------------------------------------------------")
        escreval("|              CONSULTA DE CLIENTES             |")
        escreval("-------------------------------------------------")
        escreval("               ESCOLHA UMA OPÇÃO:")
        escreval("")
        escreval(" 1 Para listar os clientes cadastrados no sistema.")
        escreval(" 2 Para consultar um cliente específico.")
        escreval(" 3 Para sair da tela de consulta.")
        leia (resp1)

        se resp1=3 entao
          limpatela
          escreval("USUÁRIO ADMINISTRADOR")
          escreval("-------------------------------------------------")
          escreval("|           AGENCIA PONTO DE PARTIDA            |")
          escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
          escreval("-------------------------------------------------")
          escreval("|                      MENU                     |")
          escreval("-------------------------------------------------")
          escreval("")
        senao
            se resp1=1 entao
              limpatela
              escreval("USUÁRIO ADMINISTRADOR")
              escreval("-------------------------------------------------")
              escreval("|           AGENCIA PONTO DE PARTIDA            |")
              escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
              escreval("-------------------------------------------------")
              escreval("|              CONSULTA DE CLIENTES              |")
              escreval("-------------------------------------------------")
              escreval("ESTES SÃO OS CLIENTES EXISTENTES NO SISTEMA:")
              listaCLIENTES(1, ultimoCliente)
              paraTela
              resp1 <-0
            senao
              se resp1=2 entao
                limpatela
                escreval("USUÁRIO ADMINISTRADOR")
                escreval("-------------------------------------------------")
                escreval("|           AGENCIA PONTO DE PARTIDA            |")
                escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                escreval("-------------------------------------------------")
                escreval("|              CONSULTA DE CLIENTES             |")
                escreval("-------------------------------------------------")
                escreval("             PESQUISE CLIENTES PELO:             ")
                escreval("                   NOME OU CPF                   ")

                leia(pesqCliente)
                pesqCliente <- maiusc(pesqCliente)
                limpatela

                quantCliente <- 0
                para l de 1 ate ultimoCliente faca
                  repeteCliente <- 0
                    para c de 1 ate 2 faca
                      se((pesqCliente = cadastroCliente[l,c]) e (repeteCliente < 1 )) entao
                        repeteCliente <- repeteCliente +1
                        quantCliente <- quantCliente +1
                      fimse
                    fimpara
                fimpara

                se quantCliente = 0 entao
                  escreval("USUÁRIO ADMINISTRADOR")
                  escreval("-------------------------------------------------")
                  escreval("|           AGENCIA PONTO DE PARTIDA            |")
                  escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                  escreval("-------------------------------------------------")
                  escreval("|              CONSULTA DE CLIENTES             |")
                  escreval("-------------------------------------------------")
                  escreval("NENHUM RESULTADO ENCONTRADO PARA A PESQUISA!")
                senao
                  escreval("USUÁRIO ADMINISTRADOR")
                  escreval("-------------------------------------------------")
                  escreval("|           AGENCIA PONTO DE PARTIDA            |")
                  escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                  escreval("-------------------------------------------------")
                  escreval("|              CONSULTA DE CLIENTES             |")
                  escreval("-------------------------------------------------")
                  escreval("CLIENTES ENCONTRADOS: ", quantCliente)
                    para l de 1 ate ultimoCliente faca
                      repeteCliente <- 0
                        para c de 1 ate 2 faca
                          se((pesqCliente = cadastroCliente[l,c]) e (repeteCliente < 1 )) entao
                              listaClientes(l,l)
                              repeteCliente <- repeteCliente +1
                          fimse
                        fimpara
                    fimpara
                fimse
                paraTela
                resp1 <-0
              senao
                limpatela
                escreval("USUÁRIO ADMINISTRADOR")
                escreval("-------------------------------------------------")
                escreval("|           AGENCIA PONTO DE PARTIDA            |")
                escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
                escreval("-------------------------------------------------")
                escreval("|              CONSULTA DE CLIENTES             |")
                escreval("-------------------------------------------------")
                escreval("OPÇÃO INVÁLIDA - DIGITE UM VALOR ENTE 1 E 3")
                paraTela
              fimse
            fimse
        fimse
      ate((resp1=1) ou (resp1= 2) ou (resp1=3))
    fimse
  fimprocedimento


//INICIO DO PROGRAMA************************************************************
Inicio

  ultimoPacote <- 0
  ultimoCliente <- 0
  resposta1 <- 0

  escreval("USUÁRIO ADMINISTRADOR")
  escreval("-------------------------------------------------")
  escreval("|           AGENCIA PONTO DE PARTIDA            |")
  escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
  escreval("-------------------------------------------------")
  escreval("|                      MENU                     |")
  escreval("-------------------------------------------------")
  escreval("")

  enquanto resposta1= 0 faca
    escreval("              O QUE VOCÊ DESEJA?")
    escreval("  1-Cadastrar Pacotes  | 3-Cadastrar Clientes ")
    escreval("  2-Consultar Pacotes  | 4-Consultar Clientes")
    escreval("              5-SAIR DO PROGRAMA")
    escreval("")
    escreva("Digite a sua Opção: ")

    leia(resposta1)
    limpatela
    escolha resposta1
      caso 1
        cadastraPacotes
        resposta1 <- 0
      caso 2
        consultaPacotes
        resposta1 <- 0
      caso 3
        cadastraClientes()
        resposta1 <- 0
      caso 4
        consultaClientes()
        resposta1 <- 0
      caso 5
        resposta1 <- 5
      outrocaso
        escreval("USUÁRIO ADMINISTRADOR")
        escreval("-------------------------------------------------")
        escreval("|           AGENCIA PONTO DE PARTIDA            |")
        escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
        escreval("-------------------------------------------------")
        escreval("|                      MENU                     |")
        escreval("-------------------------------------------------")
        escreval("OPÇÃO INVÁLIDA - DIGITE UM VALOR ENTE 1 E 5")
        resposta1 <- 0

    fimescolha
  fimenquanto

  escreval("USUÁRIO ADMINISTRADOR")
  escreval("-------------------------------------------------")
  escreval("|           AGENCIA PONTO DE PARTIDA            |")
  escreval("|    EMOCIONANTE COMO UMA PARTIDA DE FUTEBOL    |")
  escreval("-------------------------------------------------")
  escreval("|                    LOGOFF                     |")
  escreval("-------------------------------------------------")
  escreval("!!!!!ATÉ A PRÓXIMA!!!!! ")

  escreval("Pressione ESC para encerrar o programa!")
  escreval("")

  Fimalgoritmo