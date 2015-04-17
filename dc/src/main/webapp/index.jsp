<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>

    <script type="text/javascript">


        $.ajax( {
            url : '/y/user/update',
            type : 'POST',
            data : {a1:"a1111",a2:"a22222"},
            dataType : 'json',
            contentType:'application/json',
            async : false,
            success : function(data) {
                console.log(data);
                alert("success");
                alert(data.name);
                alert(data.age);

                $.ajax( {
                    url : '/CPSolutionTest/services/requestTest',
                    type : 'GET',
                    data : {a11:"a1111111111111",a22:"a2222222222222"},
                    dataType : 'json',
                    contentType:'application/json',
                    async : false,
                    success : function(data) {
                        alert("success");
                        alert(data.name);
                        alert(data.age);
                    },
                    error : function() {
                        alert("ajax error");
                    }
                });
            },
            error : function() {
                alert("ajax error");
            }
        });

    </script>
</head>
<body>

</body>
</html>
