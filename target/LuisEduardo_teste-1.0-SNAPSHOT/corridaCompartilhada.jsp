<!DOCTYPE html>
<html> 

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cadastro Corrida com validações em JS</title>
        <link rel="stylesheet" href="css/styles.css">
    </head>

    <body>
        <div id="main-container">
            <h1>Cadastro Corrida</h1>
            <form id="register-form" action="">

                <div class="half-box spacing">
                    <label for="name">Nome</label>
                    <input type="text" name="name" id="name" placeholder="Digite seu nome" data-required data-min-length="3"
                           data-max-length="16">
                </div>
                <div class="half-box spacing">
                    <label for="dataNascimento">Data Nascimento</label>
                    <input type="date" name="data" id="inputDateUser" placeholder="##/##/####" data-required>
                </div>
                <div class="half-box spacing">
                    <label for="cpf">Cpf</label>
                    <input type="text" name="cpf" id="cpf" placeholder="###-###-###-##"
                           data-cpf-validate data-required data-min-length="11"
                           data-max-length="11">>
                </div>

                <div class="half-box spacing">
                    <label class="col-sm-2 col-form-label">Sexo</label>
                    <div class="col-lg-10">
                        <select class="form-control" name="sexo" data-required>
                            <option value="1">M</option>
                            <option value="2">F</option>                    
                        </select>
                    </div>
                </div> 
                <br/>
                <br/>
                <br/>
                <div class="full-box">
                    <input id="btn-submit" type="submit" value="Registrar">
                </div>
            </form>
        </div>
        <p class="error-validation template"></p>
        <script src="js/scripts.js"></script>
    </body>

</html>


