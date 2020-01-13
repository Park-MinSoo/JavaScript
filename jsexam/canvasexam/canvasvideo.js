var canvas, video;
function initiate(){ 
  var elem=document.getElementById('canvas');
  canvas=elem.getContext('2d');
  video=document.getElementById('media');

  video.addEventListener('click', push, false);
}
function push(){
  if(!video.paused && !video.ended){	// 끝나지도 않고, 멈추지도 않았으면
    video.pause();	//잠깐 멈춰라
    window.clearInterval(loop);
  }else{
    video.play();	// 다시 플레이를 해라
    loop=setInterval(processFrames, 33);	//	33/1000 초 마다 프로세스 프레임즈를 수행해라 
  }
}
function processFrames(){	
  canvas.drawImage(video,0,0);

  var info=canvas.getImageData(0,0,483,272);	//(0,0) 좌표에 483x272만큼의 크기로 출력
  var pos;
  var gray;
  for(x=0;x<=483;x++){
    for(y=0;y<=272;y++){
      pos=(info.width*4*y)+(x*4);
      gray=parseInt(info.data[pos]*0.2989 + info.data[pos+1]*0.5870 + info.data[pos+2]*0.1140);	// 칼라를 그레이톤으로 바꾸어주는 방법이다.
      info.data[pos]=gray;
      info.data[pos+1]=gray;
      info.data[pos+2]=gray;
    }
  }
  canvas.putImageData(info,0,0);	// 다시 데이타를 넣어주는 효과이다.
}
window.addEventListener("load", initiate, false);



