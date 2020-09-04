<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Passageiros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .btn {
                border: 1px solid gray;
                padding: 5px;
                text-decoration: none;
            }
            .incluir, .sucesso {
                color: white;
                background-color: #27ae60;
            }
            .editar {
                color: white;
                background-color: #3498db;
            }
            .remover, .erro {
                color: white;
                background-color: #e74c3c;
            }
        </style>
    </head>
    <body>
        <h1>Lista de Passageiros</h1>
        <c:if test="${sessionScope.msgSucesso != null}">
            <div class="sucesso"><c:out value="${sessionScope.msgSucesso}" /></div>
            <c:remove scope="session" var="msgSucesso" />
        </c:if>
        <c:if test="${sessionScope.msgErro != null}">
            <div class="erro"><c:out value="${sessionScope.msgErro}" /></div>
            <c:remove scope="session" var="msgErro" />
        </c:if>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Data nascimento</th>
                    <th>cpf</th>
                    <th>sexo</th>
                    <th>AÇÕES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaPassageiros}" var="passageiro">
                    <tr>
                        <td><c:out value="${passageiro.idPassageiro}" /></td>
                        <td><c:out value="${passageiro.nome}" /></td>
                        <td><c:out value="${passageiro.dataNascimento}" /></td>
                        <td><c:out value="${passageiro.cpf}" /></td>
                        <td><c:out value="${passageiro.sexo}" /></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/passageiros/editar?id=${passageiro.idPassageiro}" class="btn editar">Editar</a>
                            <form method="post" action="">
                                <input type="hidden" name="id" value="${passageiro.idPassageiro}" />
                                <button type="submit" class="btn remover">Remover</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/passageiros/novo" class="btn incluir">Incluir novo</a>
        
    </body>
</html>

