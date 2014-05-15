/**
 * 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
 * 가령 압축해야 할 문자열이 aabccccccccaaa라면 a2b1c8a3과 같이 압축되어야 한다.
 * 압축결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우,
 * 이 메서드는 원래 문자열을 그대로 반환해야 한다.
 */
function compressSameString(sOriginal){
    var bCompressible = false;
    var i = 0;
    var nRepeat = 1;
    var sCompressed = "";
    var sLast = sOriginal[0];

    for(i = 0; i < sOriginal.length - 1; i++){
        if(sOriginal[i] === sOriginal[i+1]){
            bCompressible = true;
        }
    }

    if(bCompressible === false){
        return sOriginal;
    }

    for(i = 1; i < sOriginal.length; i++){
        if(sOriginal[i] === sLast){
            nRepeat++;

        } else {
            sCompressed += sLast + nRepeat;
            sLast = sOriginal[i];
            nRepeat = 1;
        }
    }

    sCompressed += sLast + nRepeat;
    return sCompressed;
}