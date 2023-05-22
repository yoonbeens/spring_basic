﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

	<%@ include file="../include/header.jsp" %>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>상세보기</p>
                        </div>
                        
                        <form action="<c:url value='/freeboard/modify'  />" method="post">
                            <div>
                                <label>DATE</label>
                                <c:if test="${article.updateDate == null}">
                                	<p>
                                		<fmt:parseDate value="${article.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
	                            		<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분" />
                                		
                                	</p>
                                </c:if>
                                <c:if test="${article.updateDate != null}">
                                	<p>
                                		<fmt:parseDate value="${article.updateDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedUpdateTime" type="both" />
	                            		<fmt:formatDate value="${parsedUpdateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분" />
                                		
                                	</p>
                                </c:if>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name="bno" value="${article.bno}" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name="writer" value="${article.writer}" readonly>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name="title" value="${article.title}" readonly>
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name="content" readonly>${article.content}</textarea>
                            </div>

                            <button type="submit" class="btn btn-primary" onclick="return confirm('변경 페이지로 이동합니다.')">변경</button>
                            <button type="button" class="btn btn-dark" onclick="location.href='${pageContext.request.contextPath}/freeboard/freeList?pageNum=${p.pageNum}&cpp=${p.cpp}&keyword=${p.keyword}&condition=${p.condition}'">목록</button>
                    </form>
                </div>
            </div>
        </div>
        </section>
        
        <!-- 댓글 영역 시작부분 -->
        <section style="margin-top: 80px;">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12 col-md-9 write-wrap">
                        <form class="reply-wrap">
                            <div class="reply-image">
                                <img src="${pageContext.request.contextPath}/img/profile.png">
                            </div>
                            <!--form-control은 부트스트랩의 클래스입니다-->
	                    <div class="reply-content">
	                        <textarea class="form-control" rows="3" id="reply"></textarea>
	                        <div class="reply-group">
	                              <div class="reply-input">
	                              <input type="text" class="form-control" id="replyId" placeholder="이름">
	                              <input type="password" class="form-control" id="replyPw" placeholder="비밀번호">
	                              </div>
	                              
	                              <button type="button" id="replyRegist" class="right btn btn-info">등록하기</button>
	                        </div>
	
	                    </div>
                        </form>

                        <!--여기에접근 반복-->
                        <div id="replyList">
                        <div class='reply-wrap'>
                            <div class='reply-image'>
                                <img src='../resources/img/profile.png'>
                            </div>
                            <div class='reply-content'>
                                <div class='reply-group'>
                                    <strong class='left'>honggildong</strong> 
                                    <small class='left'>2019/12/10</small>
                                    <a href='#' class='right'><span class='glyphicon glyphicon-pencil'></span>수정</a>
                                    <a href='#' class='right'><span class='glyphicon glyphicon-remove'></span>삭제</a>
                                </div>
                                <p class='clearfix'>여기는 댓글영역</p>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
	<!-- 모달 -->
	<div class="modal fade" id="replyModal" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="btn btn-default pull-right" data-dismiss="modal">닫기</button>
					<h4 class="modal-title">댓글수정</h4>
				</div>
				<div class="modal-body">
					<!-- 수정폼 id값을 확인하세요-->
					<div class="reply-content">
					<textarea class="form-control" rows="4" id="modalReply" placeholder="내용입력"></textarea>
					<div class="reply-group">
						<div class="reply-input">
						    <input type="hidden" id="modalRno">
							<input type="password" class="form-control" placeholder="비밀번호" id="modalPw">
						</div>
						<button class="right btn btn-info" id="modalModBtn">수정하기</button>
						<button class="right btn btn-info" id="modalDelBtn">삭제하기</button>
					</div>
					</div>
					<!-- 수정폼끝 -->
				</div>
			</div>
		</div>
	</div>
	
	
	<%@ include file="../include/footer.jsp" %>


    <script>

        window.onload = function() {

            document.getElementById('replyRegist').onclick = () => {

                const bno = '${article.bno}'; //현재 게시글 번호
                const reply = document.getElementById('reply').value;
                const replyId = document.getElementById('replyId').value;
                const replyPw = document.getElementById('replyPw').value;

                if(reply === '' || replyId === '' || replyPw === '') {
                    alert('이름, 비밀번호, 내용을 입력하세요!')
                    return;
                }

                //요청에 관련된 정보 객체
                const reqObj = {
                    method: 'post',
                    headers: {
                        'Content-Type':'application/json'
                    },
                    body: JSON.stringify({
                        'bno' : bno,
                        'reply' : reply,
                        'replyId' : replyId,
                        'replyPw' : replyPw
                    })
                };

                fetch('${pageContext.request.contextPath}/reply/regist', reqObj)
                    .then(res => res.text())
                        .then(data => {
                            console.log('통신 성공!: ' + data);
                            document.getElementById('reply').value = '';
                            document.getElementById('replyId').value = '';
                            document.getElementById('replyPw').value = '';

                            //등록 완료 후 댓글 목록 함수를 호출해서 비동기식으로 목록 표현
                            getList();
                        });

            } //댓글 등록 이벤트 끝.


            //댓글 목록을 가져올 함수
            //getList의 매개값으로 요청된 페이지 번호와, 
            //화면을 리셋할 것인지의 여부를 bool 타입의 reset으로 받겠습니다.
            //(페이지가 그대로 머물면서 댓글이 밑에 계속 쌓이기 때문에, 상황에 따라서
            //페이지를 리셋해서 새롭게 그려낼 것인지, 누적해서 쌓을 것인지의 여부를 판단.)
            function getList(pageNum, reset) {

                const bno = '${article.bno}' //게시글 번호    이미 선언하지 않았나?

                //get방식으로 댓글 목록을 요청(비동기)
                fetch('${pageContext.request.contextPath}/reply/getList' + bno + '/' + pageNum)

            }



        } //window.onload

    </script>