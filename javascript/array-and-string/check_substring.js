/**
 * 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는
 * 메서드가 있다고 하자. s1과 s2의 두 문자열이 주어졌을 때,
 * s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubstring을 한 번만 호출하도록
 * 하여 작성하라.(가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는
 * 문자열이다)
 */

function isSubstring(strA, strB){
    "use strict";
    return (strA + strA).indexOf(strB) > -1;
}

isSubstring("apple", "leapp");