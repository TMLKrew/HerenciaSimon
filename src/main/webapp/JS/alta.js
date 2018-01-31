$(document).ready(function () {
    $("#tipo").change(function () {
        var tipo = $("#tipo").val();
        $("#table").text("");
        switch (tipo) {
            case "normal" :
                $("#table").append("<tr><td>Ocupacion</td><td><input type='text' name='ocupacion' required/></td></tr>");
                break;
            case "tecnologo" :
                $("#table").append("<tr><td>A&ntilde;os estudio</td><td><input type='text' name='yearEstudio' required/></td></tr>");
                break;
            case "programador" :
                $("#table").append("<tr><td>A&ntilde;os estudio</td><td><input type='text' name='yearEstudio' required/></td></tr><tr><td>A&ntilde;os experiencia</td><td><input type='text' name='aniosDeExperiencia' required/></td></tr>\n\
                                                    <tr><td>Lenguaje favorito</td><td><input type='text' name='lenguajeFavorito' required/></td></tr>");
                break;
            case "tester" :
                $("#table").append("<tr><td>A&ntilde;os estudio</td><td><input type='text' name='yearEstudio' required/></td></tr><tr><td>Herramientas de tester</td><td><input type='text' name='herramientasDeTester' required/></td></tr>");
                break;
        }
    })
})

