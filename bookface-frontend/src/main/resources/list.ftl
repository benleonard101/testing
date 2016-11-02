
<#-- @ftlvariable name="" type="com.kainos.training.dropwizard.login.frontends.views.BookView" -->


<h1>People list</h1>
<p class="lead">books ${bookCount}</p>

<table class="table">
    <thead>
        <th>Title</th>
        <th>Author</th>
        <th>Book Link</th>
    </thead>

    <tbody>
        <#list books as book>
            <tr>
            <td>
                ${book.title}
            </td>
            <td>
                ${book.author}
            </td>
            <td>
            <a href="http://localhost:8900/test/books/${book.id}">click here </a>
            </td>
            </tr>
        </#list>

    </tbody>
</table>