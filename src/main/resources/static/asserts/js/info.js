var mainTypeArr = [];
mainTypeArr[0] = ['气节'];
mainTypeArr[1] = ['四季'];
mainTypeArr[2] = ['人群'];

var subTypeArr = [];
subTypeArr[1] = ['春季','夏季', '秋季','冬季'];
subTypeArr[0] = ['立春','雨水','惊蛰', '春分', '清明', '谷雨', '立夏', '小满', '芒种', '夏至', '小暑', '大暑',
    '立秋', '处暑', '白露', '秋分', '寒露', '霜降', '立冬','小雪', '大雪', '冬至', '小寒', '大寒'];
subTypeArr[2] = ['儿童','青年','老年'];

function myFunction(index) {
    return subTypeArr[0][index];
}