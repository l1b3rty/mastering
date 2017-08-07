<h1>Error Page</h1>
<p>Application has encountered an error. Please contact support on ...</p>

Exception:  ${ex.message}
<c:forEach items="${ex.stackTrace}" var="ste">
    ${ste}
</c:forEach>
