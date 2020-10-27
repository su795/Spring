<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<jsp:include page="./inc/_aside_${group}.jsp"/>

<script>
	$(document).ready(function(){
		console.log("pageEnd : ", ${pageEnd});
		console.log("currentPage : ", ${currentPage});
		console.log("count : ", ${count});
		console.log("total : ", ${total});
		console.log("groupCurrent : ", ${groupCurrent});
		console.log("groupStart : ", ${groupStart});
		console.log("groupEnd : ", ${groupEnd});
	});
</script>
<body>
    <div id="wrapper">
        <section id="board" class="list">
            <h3>글목록</h3>
            <article>                
                <table border="0">
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>날짜</th>
                        <th>조회</th>
                    </tr>
                    <c:forEach var="board" items="${boards}">
	                    <tr>
	                        <td>${count=count-1}</td>
	                        <td><a href="/farmstory/view?seq=${board.seq}">${board.title}</a>&nbsp;[${board.comment}]</td>
	                        <td>${board.nick}</td>
	                        <td>${board.rdate.substring(2, 10)}</td>
	                        <td>${board.hit}</td>
	                    </tr>
                    </c:forEach>
                </table>
            </article>

            <!-- 페이지 네비게이션 -->
            <div class="paging">
                <a href="/farmstory/list?pg=${groupStart-1}" class="prev">이전</a>
                <c:forEach var="i" begin="${groupStart}" end="${groupEnd}">
                	<a href="/farmstory/list?pg=${i}" class="num ${currentPage == i ? 'current':''}">${i}</a>
				</c:forEach>     
                <a href="/farmstory/list?pg=${groupEnd+1}" class="next">다음</a>
            </div>

            <!-- 글쓰기 버튼 -->
            <a href="/farmstory/board/write?group=${group}&cate=${cate}" class="btnWrite">글쓰기</a>

        </section>



<%@ include file="./inc/_aside_tail.jsp" %>
<%@ include file="../_footer.jsp" %>