#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <conio.h> 
#include<time.h>

#include <graphics.h> //1.包含图像库头文件
#pragma comment(lib, "MSIMG32.LIB")
#pragma comment(lib,"winmm.lib")
#define WIDTH  591
#define HIGHT  864
#define BULLET_Num 15//玩家子弹的数量
#define ENEMY_NUM  20//敌机的数量
int bullet_rank = 0;//战机子弹的等级
int score = 0;//得分
enum My
{
	BIG,
	SMALL
};
struct plance//飞机结构
{
	int x;
	int y;
	bool live;//是否存活
	int width;//敌机的宽
	int height;//敌机的高度
	int hp;//敌机血量
	int type;//敌机种类
}player, bull[BULLET_Num], enemy[ENEMY_NUM], PlanExplode;


 //int boss.w = 200;
 //int boss.h = 213;
 // int   boss.life = 100;
 // int boss.add_x = 2;
 // int boss.add_y = 1;
 // int 	
 // int 


IMAGE imgBack;  //存放背景图片
IMAGE img_role[2];    //图片变量,用来存放战机图片文件
IMAGE img_bull[3][3];//图片变量，用来存放战机子弹照片
IMAGE img_enemy[2][2];//图片变量，用来存放敌机照片
IMAGE img_boss[2];//图片变量，用来存放boss照片
IMAGE img_planExplode;
 

void loadImg()
{
	//装载背景图片文件到imgBack里
	loadimage(&imgBack, "游戏背景图.png", WIDTH, HIGHT);
	//将图片文件装入 img_role 变量中
	loadimage(&img_role[0], "战机图二.jpg");//源码图飞机
	loadimage(&img_role[1], "战机图一.jpg");//现实图片飞机
	//将敌机图片文件加载到img_enemy里
	loadimage(&img_enemy[0][0], "敌机2.0.jpg");
	loadimage(&img_enemy[0][1], "敌机2.jpg");
	loadimage(&img_enemy[1][0], "敌机图二.jpg");
	loadimage(&img_enemy[1][1], "敌机图二.1.jpg");
	//将子弹图片文件加载到img_bull里
	loadimage(&img_bull[0][0], "子弹图1.jpg");
	loadimage(&img_bull[0][1], "子弹图2.jpg");
	loadimage(&img_bull[1][0], "子弹2.jpg");
	loadimage(&img_bull[1][1], "子弹2原图.jpg");
	loadimage(&img_bull[2][0], "子弹三.jpg");
	loadimage(&img_bull[2][1], "子弹三原图.jpg");
	//将飞机爆炸图片文件加载到img_planExplode里
	loadimage(&img_planExplode, "大爆炸.jpg");
}






void enemyHP(int j)//飞机种类函数
{
	int flag = rand() % 10;
	if (flag >= 0 && flag <= 2)
	{
		enemy[j].type = BIG;
		enemy[j].width = 104;
		enemy[j].height = 148;
		enemy[j].hp = 3;
	}
	else
	{
		enemy[j].type = SMALL;
		enemy[j].width = 52;
		enemy[j].height = 39;
		enemy[j].hp = 1;

	}
}
void gameInit()//游戏初始化函数
{
	int i;
	int j;
	loadImg();//将游戏背景加载到图形设备的内存
	mciSendString(_T("play 韩宝仪-往事只能回味.mp3 repeat"), NULL, 0, NULL);
	player.x = WIDTH / 2 - 48;
	player.y = HIGHT - 150;
	PlanExplode.x = -700;
	PlanExplode.y = 0;
	//boss.x = WIDTH / 2 - boss.w / 2;
	//boss.y = -213;
	for (i = 0; i < BULLET_Num; i++)//初始化子弹
	{
		bull[i].x = 0;
		bull[i].y = 0;
		bull[i].live = false;
	}
	//初始化敌机
	for (j = 0; j < ENEMY_NUM; j++)
	{
		enemy[j].live = false;
		enemyHP(j);
	}
}

void gameDraw()
{
	int i;
	int j;
	//将imgBack绘制到指定坐标位置
	putimage(0, 0, &imgBack);
	//将img_role绘制到指定坐标位置，用源码图覆盖原图
		player.live = true;
		putimage(player.x, player.y, &img_role[0], NOTSRCERASE);
		putimage(player.x, player.y, &img_role[1], SRCINVERT);
		putimage(PlanExplode.x, PlanExplode.y, &img_planExplode);
	for (i = 0; i < BULLET_Num; i++)//绘制子弹
	{
		if (bull[i].live)
		{
			putimage(bull[i].x, bull[i].y, &img_bull[bullet_rank][0], NOTSRCERASE);
			putimage(bull[i].x, bull[i].y, &img_bull[bullet_rank][1], SRCINVERT);
		}
	}
	for (j = 0; j < ENEMY_NUM; j++)//绘制敌机
	{
		if (enemy[j].live)
		{
			if (enemy[j].type == BIG)
			{
				putimage(enemy[j].x, enemy[j].y, &img_enemy[1][0], NOTSRCERASE);
				putimage(enemy[j].x, enemy[j].y, &img_enemy[1][1], SRCINVERT);
			}

			else
			{
				putimage(enemy[j].x, enemy[j].y, &img_enemy[0][0], NOTSRCERASE);
				putimage(enemy[j].x, enemy[j].y, &img_enemy[0][1], SRCINVERT);
			}
		}
	}
}
void createBullet()//产生子弹，一开始初始化的时候子弹没有的
{
	int i;
	for (i = 0; i < BULLET_Num; i++)
	{
		if (!bull[i].live)
		{
			if (bullet_rank == 0)
			{
				bull[i].x = player.x + 45;//调整子弹的坐标
				bull[i].y = player.y;//调整子弹的坐标
				bull[i].live = true;
				break;
			}
			else if (bullet_rank == 1)
			{
				bull[i].x = player.x + 30;//调整子弹的坐标
				bull[i].y = player.y;//调整子弹的坐标
				bull[i].live = true;
				break;
			}
			else if (bullet_rank == 2)
			{
				bull[i].x = player.x + 20;//调整子弹的坐标
				bull[i].y = player.y;//调整子弹的坐标
				bull[i].live = true;
				break;
			}

		}
	}
}




void BulletMove(int speed)
{
	int i;
	for (i = 0; i < BULLET_Num; i++)
	{
		if (bull[i].live)
		{
			bull[i].y -= speed;
			if (bull[i].y < 0)
			{
				bull[i].live = false;
			}
		}
	}
}

bool Timer(int ms, int id)//定时器函数
{
	static DWORD t[10];

	if (clock() - t[id] > ms)
	{
		t[id] = clock();
		return true;
	}
	return false;
}


void playerMove(int speed)
{
	if (GetAsyncKeyState(VK_UP) || GetAsyncKeyState('W'))
	{
		if (player.y > 0)
		{
			player.y -= speed;
		}
	}
	if (GetAsyncKeyState(VK_DOWN) || GetAsyncKeyState('S'))
	{
		if (player.y + 158 < 864)
		{
			player.y += speed;
		}
	}
	if (GetAsyncKeyState(VK_LEFT) || GetAsyncKeyState('A'))
	{
		if (player.x + 36 > 0)
		{
			player.x -= speed;
		}

	}
	if (GetAsyncKeyState(VK_RIGHT) || GetAsyncKeyState('D'))
	{
		if (player.x + 58 < 591)
		{
			player.x += speed;
		}

	}
	if (GetAsyncKeyState(VK_SPACE) && Timer(200, 1))
	{
		createBullet();
		mciSendString(_T("play 子弹连发.mp3 "), NULL, 0, NULL);
	}
}


void createEnemy()
{
	int i;
	for (i = 0; i < ENEMY_NUM; i++)
	{
		if (!enemy[i].live)
		{
			enemy[i].live = true;
			enemy[i].x = rand() % (WIDTH - 50);
			enemy[i].y = 0;
			enemyHP(i);
			break;
		}
	}
}
void enemyMove(int speed)
{
	int i;
	for (i = 0; i < ENEMY_NUM; i++)
	{
		if (enemy[i].live)
		{
			enemy[i].y += speed;
			if (enemy[i].y>HIGHT)
			{
				enemy[i].live = false;
			}
		}
	}
}

void playPlance()
{
	int i, k;
	for (i = 0; i < ENEMY_NUM; i++)
	{
		if (!enemy[i].live)
			continue;
		for (k = 0; k < BULLET_Num; k++)
		{
			if (!bull[k].live)
				continue;
			if (bull[k].x>enemy[i].x && bull[k].x<enemy[i].x + enemy[i].width
				&&bull[k].y>enemy[i].y && bull[k].y < enemy[i].y + enemy[i].height)
			{
				bull[k].live = false;
				enemy[i].hp--;
				mciSendString(_T("play 爆炸声.mp3 "), NULL, 0, NULL);
			}
		}
		if (enemy[i].hp <= 0)
		{
			PlanExplode.x = enemy[i].x;
			PlanExplode.y = enemy[i].y;
			score++;
			enemy[i].live = false;
			if (score == 3)
			{
				bullet_rank += 1;
				break;
			}
			if (score == 12)
			{
				bullet_rank += 1;
				break;
			}
		}
		
	}
}



void main(void)
{
	initgraph(WIDTH, HIGHT); //初始化图形设备
	gameInit();
	BeginBatchDraw();//双缓冲绘图
	while (1)
	{
		gameDraw();//将游戏背景输出到图形界面
		FlushBatchDraw();//刷新获取图片
		playerMove(1);
		BulletMove(3);
		//BossMove(1);//Boss移动
		if (Timer(500, 1))
		{
			createEnemy();//创造敌机
		}
		if (Timer(8, 2))
		{
			enemyMove(1);//敌机移动
		}
		playPlance();//打飞机函数
	}
	EndBatchDraw();
	closegraph();//关闭图形设备
}













/*

#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<time.h>

#define KEY_LEFT (1000 + 75)
#define KEY_RIGHT (1000 + 77)
#define KEY_UP (1000 + 72)
#define KEY_DOWN (1000 + 80)
#define SPACE 32

IMAGE img, imgBack, imgPlane;
IMAGE Bullt;
int xCar, yCar;
int xPlane, yPlane;
int xBullt, yBullt;

int getKey()
{
	int key;
	key = getch();
	if (key == 224)
	{
		key = getch();
		return (1000 + key);
	}
	return key;
}

void Init()
{
	
	initgraph(640, 480);//初始化图形设备
	loadimage(&imgBack, "游戏背景2.jpg", 640, 480);//装载背景图片文件到imBack中
	xCar = 300;
	yCar = 200;
	xPlane = 640;
	yPlane = 0;
	loadimage(&img, "防空车.bmp");
	loadimage(&imgPlane, "plane2.bmp");
	putimage(0, 0, &imgBack);
	//将img绘制到指定坐标位置
	putimage(xCar, yCar, &img);
	putimage(xPlane, yPlane, &imgPlane);

}
void Diplan()
{
	clock_t end, start;
	start = clock();
	end = start;
	end = clock();
	if (end - start > 100)
	{
		start = end;
		yPlane = yPlane + 5;
		if (yPlane > 100)
		{
			xPlane = 320;
			yPlane = 0;
		}
	}
}
void PlaneMove()
{
	int key;
	if (kbhit())
	{
		key = getKey();
		switch (key)
		{
		case KEY_LEFT:
			xCar = xCar - 5;
			break;
		case KEY_RIGHT:
			xCar = xCar + 5;
			break;
		case KEY_UP:
			yCar = yCar - 5;
			break;
		case KEY_DOWN:
			yCar = yCar + 5;
			break;
		default:
			break;
		}
	}
}
void main(void)
{
	
	while (1)
	{
		Init();//初始游戏函数
		Diplan();
		PlaneMove();

	}
	//关闭图形设备
	closegraph();
}
*/
