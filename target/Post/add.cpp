#include <SFML/Graphics.hpp>
#include <cassert> 
#include <stdio.h>
#include <iostream>
#include <windows.h>
#include <time.h>
#include <string>
#include <exception>
#include <conio.h>
#include <stdlib.h>
#include <cstdlib>
#include <algorithm>
#include <SFML/Config.hpp>
#include <SFML/System/Export.hpp>
#include "TetrisGameEngine.h"


using namespace std;
using namespace sf;
bool automaticPlaying = true;



const float windowWidth = 500;
const float windowHeight = 500;




//text 함수 
int textprint(Text& text, Font& font, int size, float x, float y, const Color& color, const Color& outColor, string p) 

{
   text.setFont(font);
   text.setCharacterSize(size);
   text.setPosition(x, y);
   text.setFillColor(color);
   text.setOutlineColor(outColor);
   text.setOutlineThickness(1.f);
   text.setString(p);
   return 0;


}



int main() {

   Text text;
   Text text2;
   Uint8 r = 0, g = 0, b = 0;
   string comment = "tetris Game Start";
   string hi = "PRESS THIS BUTTON TO START !"; //스페이스 바를 누르면 게임시작
   int x = 0, y = 0;
   Clock clock;  //경과 시간 측정
   float interval = 0;

   RenderWindow window(VideoMode(windowWidth, windowHeight), "tetris");


   window.setFramerateLimit(60);

   //시작화면 text 
   Font font;
   if (!font.loadFromFile("C:/Users/User/Downloads/DungGeunMo TTF/DungGeunMo.ttf"))
      throw exception("font error");
   textprint(text, font, 100, 700, 30, Color::Green, Color::Black, comment);
   textprint(text2, font, 30, 50, 300, Color::Black, Color::Black, hi);





   while (window.isOpen()) {

      text.move(-1, 0);

      window.clear(Color::White);
      window.draw(text);
      window.draw(text2);
      window.display();
      Event event;

      while (window.pollEvent(event)) {


         switch (event.type) {

         case Event::Closed:
            window.close();
            break;

         case Event::MouseButtonPressed:
            if (event.mouseButton.button == Mouse::Left) {
               window.create(VideoMode(windowWidth, windowHeight), "tetris game");
               TetrisGameEngine tge;

               Texture t1, t2, t3;
               t1.loadFromFile("C:/Users/User/OneDrive/사진/tile.png");
               t2.loadFromFile("C:/Users/User/OneDrive/사진/blank.png");
               t3.loadFromFile("C:/Users/User/OneDrive/사진/frame.png");

               Sprite tileSprite(t1);
               Sprite frame(t3);
               Sprite blank(t2);




               text2.move(1000, 0);
               while (window.isOpen()) {
                  Event e;

                  window.clear(Color::Black);


                  window.draw(frame);
                  window.display();
                  

                     TetrisGameEngine tge;

                     int i = 0;
                     while (i < 10) {
                        // (1) 초기화
                        tge.initialize();

                        int lines = 0;

                        // (2) 게임이 끝날때까지 반복
                        while (tge.getStatus() != GAMEOVER) {

                           // (3) 게임 상태에서 블럭을 새로 만들어야 하는 시점이라면 move(INIT)
                           //     그렇지 않으면 move(LEFT / RIGHT / DOWN / DROP) 중 선택
                           if (tge.getStatus() == CREATINGANEWBLOCK) {

                              // 모두 채워진 줄이 있으면 그 줄의 벽돌들을 없애고
                              lines = lines + tge.getScore();

                              // 새로 벽돌을 만듬
                              tge.move(INIT);
                           }
                           else {
                              if (automaticPlaying) {
                                 // For automatic playing
                                 int i = rand() % 5 + 1;
                                 tge.move((BrickMove)i);
                              }
                              else {
                                 // For manual playing
                                 //cout << "[left/right/up/down/drop] > ";
                                 string in;
                            while (window.pollEvent(e)){
                                 if (Keyboard::isKeyPressed(Keyboard::Left)) {
                                    tge.move(LEFT);
                                 }
                                 if (Keyboard::isKeyPressed(Keyboard::Right)) {
                                    tge.move(RIGHT);
                                 }
                                 if (Keyboard::isKeyPressed(Keyboard::Up)) {
                                    tge.move(UP);
                                 }
                                 if (Keyboard::isKeyPressed(Keyboard::Down)) {
                                    tge.move(DOWN);
                                 }
                                 if (Keyboard::isKeyPressed(Keyboard::Space)) {
                                    tge.move(DROP);
                                 }
                            }
                                 /*cin >> in;
                                 if (in == "left") tge.move(LEFT);
                                 else if (in == "right") tge.move(RIGHT);
                                 else if (in == "up") tge.move(UP);
                                 else if (in == "down") tge.move(DOWN);
                                 else if (in == "drop") tge.move(DROP);
                               }
                             }*/

                             // (4) move(...) 에 따라 달라진 게임 보드를 그리기
                                 //system("cls");
                                 //cout << lines << " lines are removed..." << endl;


                                 int w = tge.getWidth();
                                 int h = tge.getHeight();

                                 for (int y = 0; y < h; y++) {
                                    //cout << "|"; // 왼쪽 벽

                                    for (int x = 0; x < w; x++) {
                                       if (tge.getBoard(x, y) != EMPTY) {
                                          window.draw(tileSprite);


                                       }
                                       else
                                          window.draw(blank);
                                    }

                                    //cout << "|" << endl; // 오른쪽 벽


                                    Sleep(100);
                                 }

                              }
                           }

                           // 아래 바닥
                           //cout << "+";
                           //for (int x = 0; x < w; x++)
                              //cout << "_";
                           //cout << "+" << endl;
                        }



                     }






                  
               }

               return 0;

            }
         }
      }
   }
}