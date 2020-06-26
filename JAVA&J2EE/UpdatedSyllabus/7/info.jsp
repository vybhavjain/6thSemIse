<html>
    <body>
        <h1>
            Form to Insert Details
        </h1>
        <form action="Insert" method="POST">
            Id<input name="id">
            Name<input name="name">
            Age<input name="age">
            Date of Admission<input name="doa">
            Cause of Admission<input name="coa">
            Doctor<input name="doc">
            Diagnosis<input name="diag">
            Treatment<input name="treat">
            <input type="submit">
        </form><br>
        <h1>
            Form to Update Details
        </h1>
        <form action="Update" method="POST">
            Id<input name="id">
            Name<input name="name">
            Age<input name="age">
            Date of Admission<input name="doa">
            Cause of Admission<input name="coa">
            Doctor<input name="doc">
            Diagnosis<input name="diag">
            Treatment<input name="treat">
            <input type="submit">
        </form>
        <br>
        <h1>
            Form to Delete Details
        </h1>
        <form action="Delete" method="POST">
            Id<input name="id">
            <input type="submit">
        </form>
        <form action="View" method="GET">
            View Details<input type="submit">
        </form>
    </body>
</html>