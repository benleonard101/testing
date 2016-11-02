
<#-- @ftlvariable name="" type="com.kainos.training.dropwizard.login.frontends.views.BookDetailView" -->


<h1>Book </h1>


<table class="table">
    <thead>
        <th>Title</th>
        <th>Author</th>
        <th>Link</th>
    </thead>

    <tbody>

            <tr>
            <td>
                ${book.title}
            </td>
            <td>
                ${book.author}
            </td>

            <td>
<a href="http://localhost:8900/test/books/${book.id}" name="click to view">

            </td>


            </tr>


    </tbody>


</table>