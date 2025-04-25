<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<%@ include file="header.jsp"%>

<body>
    <div class="container mt-5">
        <h2>Registered Customers</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Contact</th>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="customer" items="${customers}">
                    <tr>
                        <td>${customer.id}</td>
                        <td>${customer.cname}</td>
                        <td>${customer.email}</td>
                        <td>${customer.cadd}</td>
                        <td>${customer.mob}</td>
                        <td>${customer.unm}</td>
                        <td>${customer.pw}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
<%@include file="footer.jsp" %>
