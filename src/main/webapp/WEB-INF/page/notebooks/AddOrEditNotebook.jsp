<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Main -->
<div id="main">
	<div class="inner">
		<header>
			<h1>新增筆記本</h1>
			<p>在這裏你可以新增或設定是否公開筆記本</p>
		</header>
		<section>
			<form method="post" action="#">
				<div class="row gtr-uniform">
					<div class="col-6 col-12-xsmall">
						<input type="text" name="demo-name" id="demo-name" value=""
							placeholder="筆記名稱">
					</div>
					<div class="col-6 col-12-xsmall">
						<select name="demo-category" id="demo-category">
							<option value="">- 筆記本群組 -</option>
							<option value="1">Manufacturing</option>
							<option value="1">Shipping</option>
							<option value="1">Administration</option>
							<option value="1">Human Resources</option>
						</select>
					</div>
					<div class="col-12">
						<div class="textarea-wrapper">
							<textarea name="demo-message" id="demo-message"
								placeholder="新增描述" rows="1"
								style="overflow: hidden; resize: none; height: 69px;"></textarea>
						</div>
					</div>

					<!--
                                        <div class="col-12">
                                            <select name="demo-category" id="demo-category">
                                                <option value="">- Category -</option>
                                                <option value="1">Manufacturing</option>
                                                <option value="1">Shipping</option>
                                                <option value="1">Administration</option>
                                                <option value="1">Human Resources</option>
                                            </select>
                                        </div>
                                        <div class="col-4 col-12-small">
                                            <input type="radio" id="demo-priority-low" name="demo-priority" checked="">
                                            <label for="demo-priority-low">Low</label>
                                        </div>
                                        <div class="col-4 col-12-small">
                                            <input type="radio" id="demo-priority-normal" name="demo-priority">
                                            <label for="demo-priority-normal">Normal</label>
                                        </div>
                                        <div class="col-4 col-12-small">
                                            <input type="radio" id="demo-priority-high" name="demo-priority">
                                            <label for="demo-priority-high">High</label>
                                        </div>
                                        -->
					<div class="col-6 col-12-small">
						<input type="checkbox" id="demo-copy" name="demo-copy"> <label
							for="demo-copy">是否公開</label>
					</div>
					<div class="col-6 col-12-small">
						<input type="checkbox" id="demo-human" name="demo-human"
							checked=""> <label for="demo-human">是否...</label>
					</div>
					<div class="col-12">
						<ul class="actions">
							<li><input type="submit" value="儲存" class="primary"></li>
							<li><input type="reset" value="重新填寫"></li>
						</ul>
					</div>
				</div>
			</form>
		</section>
	</div>
</div>

