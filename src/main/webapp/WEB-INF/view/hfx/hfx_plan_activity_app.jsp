<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head lang="en">
    <title>【红岭创投】安全运营8年，千亿级平台，已为投资人赚取超60亿收益，百万投资人就差你啦！</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="author" content="m.my089.com" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="format-detection" content="telephone=no" />
    <meta name="description" content="【红岭创投】安全运营8年，千亿级平台，已为投资人赚取超60亿收益，百万投资人就差你啦！" />
</head>
<body>
<div class="content" style="min-height: 400px;">
    <!--兑奖记录 弹出框-->
    <div class="X-Mask-DJ X-Mask-close">
        <div class="YQ-Record">
            <h2>兑奖记录</h2>
            <div class="YQRecordCont">
                <table cellpadding="0" cellspacing="0">
                    <tr>
                        <th>兑换时间</th>
                        <th></th>
                        <th>兑换奖品</th>
                        <th></th>
                        <th>消耗人气值</th>
                    </tr>
                    <c:if test="${exchangeList.size() > 0}">
                        <c:forEach items="${exchangeList}" var="exchange">
                            <tr>
                                <td class="td-1"><fmt:formatDate value="${exchange.exchangeTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                                <td>&nbsp;&nbsp;</td>
                                <td class="td-2">${exchange.prizesName}</td>
                                <td>&nbsp;&nbsp;</td>
                                <td class="td-3">${exchange.spendReputation}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
                <c:if test="${exchangeList == null || exchangeList.size() == 0}">
                    <div class="RecordNone">暂无记录</div>
                </c:if>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        //点击兑换奖品
        function exchangePrizes(){
            $.ajax({
                type: "POST",
                url: "/activityHfxPlan/exchangePrizes",
                cache : false,
                data:$('#exchangeForm').serialize(),
                dataType : 'json',
                success: function (result) {

                },
                error: function () {

                }
            });
        }

    </script>
</div>
</body>

