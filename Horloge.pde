/** Horloge
 * Clément Truillet (clement@ctruillet.eu)
 * 16/02/2020
 *
 *
 */
 
PFont font; 
float day, hour, minute, second; 
 
 
void setup(){
  size(640,360); 
  font = loadFont("AgencyFB-Reg-48.vlw");
}


void draw(){
  textFont(font,40);
  float x= 0 , y = 0;
  
  background(200);
  strokeCap(SQUARE);
  ellipseMode(CENTER);
  translate(width/2, height/2);
  textAlign(CENTER);
  
  //Recuperation des valeurs
  day = day();
  hour = hour();
  minute = minute();
  second = second();
  
  
  
  //Affichage Textuel
  fill((day/31.0*255)%128+128);
  text((hour<10.0?"0":"") + (int)hour + ":" + (minute<10.0?"0":"") + (int)minute ,0,-10);
  textSize(30);
  text((day<10.0?"0":"") + (int)day + "/" + (month()<10.0?"0":"") + (int)month() + "/" + year() ,0,+40);
  
  //Heures
  noFill();
  strokeWeight(10);
  stroke((day/31.0)+80);
  arc(0,0,218,218,-HALF_PI,(2*PI * (60*hour+minute)/(60.0*24.0))-HALF_PI);
  
  //Minutes
  noFill();
  strokeWeight(10);
  stroke((day/31.0*255)%128+96);
  //arc(0,0,200,200,-HALF_PI,(2*PI * minute/60.0)-HALF_PI);
  arc(0,0,200,200,-HALF_PI,(2*PI * (60*minute+second)/(60.0*60.0))-HALF_PI);
  
  //Seconde
  noStroke();
  fill((day/31.0*255)%128+112);
  x = 80 * cos(HALF_PI+2*PI*(millis()%60000)/1000.0);
  ellipse(x, y, 20, 20);  
}
