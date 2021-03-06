<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/Calendar.css">

		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/Calendar.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
 

<div class="container">
    <form class="well span7" action="Calendar" method="post">
        <legend class="text-center" style="color: #fff"><img src="http://i.imgur.com/0KyKwkh.png"> Make an Appointment</legend>
        <div class="row">
            <div class="span2">
                <label class="" >First Name</label>
                <input disabled type="text" name = "first_name" class="span2" placeholder="" value="${profile.getFirstName()}">
                <label class="" >Last Name</label>
                <input disabled type="text" name = "last_name" class="span2" placeholder="" value="${profile.getLastName()}">
                <label class="" >Phone</label>
                <input type="text" name = "phone" class="span2" placeholder="">
                <label class="" >Email</label>
                <input disabled type="text" name= "email" class="span2" placeholder="" value="${profile.getUsername()}">
                <select id="subject" name="regarding" class="span2">
                    <option value="na" selected="" class="">Visit regarding...</option>
                    <option value="MySon" class="">My son</option>
                    <option value="MyDaughter" class="">My Daughter</option>
                    <option value="MyChild" class="">My step-son</option>
                    <option value="MyChild" class="">My step-daughter</option>
                    <option value="Nephew" class="">Nephew</option>
                    <option value="Niece" class="">Niece</option>
                    <option value="Niece" class="">Cousin</option>
                    <option value="MyChild" class="">Other</option>
                </select>
            </div>
            <div class="span5">
                <p class="">First Choice Date &amp; Time</p>
                <div class="btn-toolbar" style="margin: 0;">
                    <div class="btn-group">
                        <select class="" name = "month">
                            <option value="Month" class="">- Month -</option>
                            <option value="January" class="">January</option>
                            <option value="February" class="">February</option>
                            <option value="March" class="">March</option>
                            <option value="April" class="">April</option>
                            <option value="May" class="">May</option>
                            <option value="June" class="">June</option>
                            <option value="July" class="">July</option>
                            <option value="August" class="">August</option>
                            <option value="September" class="">September</option>
                            <option value="October" class="">October</option>
                            <option value="November" class="">November</option>
                            <option value="December" class="">December</option>
                        </select>
                        <select class="" name = "day">
                            <option value="Day" class="">- Day -</option>
                            <option value="01" class="">1</option>
                            <option value="02" class="">2</option>
                            <option value="03" class="">3</option>
                            <option value="03" class="">4</option>
                            <option value="03" class="">5</option>
                            <option value="03" class="">6</option>
                            <option value="03" class="">7</option>
                            <option value="03" class="">8</option>
                            <option value="03" class="">9</option>
                            <option value="03" class="">10</option>
                            <option value="03" class="">11</option>
                            <option value="03" class="">12</option>
                            <option value="03" class="">13</option>
                            <option value="03" class="">14</option>
                            <option value="03" class="">15</option>
                            <option value="03" class="">16</option>
                            <option value="03" class="">17</option>
                            <option value="03" class="">18</option>
                            <option value="03" class="">19</option>
                            <option value="03" class="">20</option>
                            <option value="03" class="">21</option>
                            <option value="03" class="">22</option>
                            <option value="03" class="">23</option>
                            <option value="03" class="">24</option>
                            <option value="03" class="">25</option>
                            <option value="03" class="">26</option>
                            <option value="03" class="">27</option>
                            <option value="03" class="">28</option>
                            <option value="03" class="">29</option>
                            <option value="03" class="">30</option>
                            <option value="03" class="">31</option>
                        </select>
                        <select class="" name = "time">
                            <option value="Time" class="">Time am/pm</option>
                            <option value="10am" class="">10:00am</option>
                            <option value="1030am" class="">10:30am</option>
                            <option value="11am" class="">11:00am</option>
                            <option value="1130am" class="">11:30am</option>
                            <option value="12pm" class="">12:00pm</option>
                            <option value="1230pm" class="">12:30pm</option>
                            <option value="1pm" class="">1:00pm</option>
                            <option value="130pm" class="">1:30pm</option>
                            <option value="2pm" class="">2:00pm</option>
                            <option value="230pm" class="">2:30pm</option>
                            <option value="3pm" class="">3:00pm</option>
                            <option value="330pm" class="">3:30pm</option>
                            <option value="4pm" class="">4:00pm</option>
                            <option value="430pm" class="">4:30pm</option>
                        </select>
                        <label class="">Second Choice Date &amp; Time</label>
                        <select class="">
                            <option value="Month" class="">- Month -</option>
                            <option value="January" class="">January</option>
                            <option value="February" class="">February</option>
                            <option value="March" class="">March</option>
                            <option value="April" class="">April</option>
                            <option value="May" class="">May</option>
                            <option value="June" class="">June</option>
                            <option value="July" class="">July</option>
                            <option value="August" class="">August</option>
                            <option value="September" class="">September</option>
                            <option value="October" class="">October</option>
                            <option value="November" class="">November</option>
                            <option value="December" class="">December</option>
                        </select>
                        <select class="">
                            <option value="Day" class="">- Day -</option>
                            <option value="01" class="">1</option>
                            <option value="02" class="">2</option>
                            <option value="03" class="">3</option>
                            <option value="03" class="">4</option>
                            <option value="03" class="">5</option>
                            <option value="03" class="">6</option>
                            <option value="03" class="">7</option>
                            <option value="03" class="">8</option>
                            <option value="03" class="">9</option>
                            <option value="03" class="">10</option>
                            <option value="03" class="">11</option>
                            <option value="03" class="">12</option>
                            <option value="03" class="">13</option>
                            <option value="03" class="">14</option>
                            <option value="03" class="">15</option>
                            <option value="03" class="">16</option>
                            <option value="03" class="">17</option>
                            <option value="03" class="">18</option>
                            <option value="03" class="">19</option>
                            <option value="03" class="">20</option>
                            <option value="03" class="">21</option>
                            <option value="03" class="">22</option>
                            <option value="03" class="">23</option>
                            <option value="03" class="">24</option>
                            <option value="03" class="">25</option>
                            <option value="03" class="">26</option>
                            <option value="03" class="">27</option>
                            <option value="03" class="">28</option>
                            <option value="03" class="">29</option>
                            <option value="03" class="">30</option>
                            <option value="03" class="">31</option>
                        </select>
                        <select class="">
                            <option value="Time" class="">Time am/pm</option>
                            <option value="10am" class="">10:00am</option>
                            <option value="1030am" class="">10:30am</option>
                            <option value="11am" class="">11:00am</option>
                            <option value="1130am" class="">11:30am</option>
                            <option value="12pm" class="">12:00pm</option>
                            <option value="1230pm" class="">12:30pm</option>
                            <option value="1pm" class="">1:00pm</option>
                            <option value="130pm" class="">1:30pm</option>
                            <option value="2pm" class="">2:00pm</option>
                            <option value="230pm" class="">2:30pm</option>
                            <option value="3pm" class="">3:00pm</option>
                            <option value="330pm" class="">3:30pm</option>
                            <option value="4pm" class="">4:00pm</option>
                            <option value="430pm" class="">4:30pm</option>
                        </select>
                    </div>
                    <!-- /btn-group -->
                </div>
                <label class="">Message</label>
                <textarea name="message" id="message" class="span4" rows="10" style="width: 96%"></textarea>
            </div>
            <button type="submit" class="btn btn-warning" style="margin-left: 32%;" contenteditable="false">Submit</button>
        </div>
    </form>
</div>

    
    </jsp:body>
</t:genericpage>
