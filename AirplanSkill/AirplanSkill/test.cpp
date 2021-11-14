#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <conio.h> 
#include<time.h>

#include <graphics.h> //1.����ͼ���ͷ�ļ�
#pragma comment(lib, "MSIMG32.LIB")
#pragma comment(lib,"winmm.lib")
#define WIDTH  591
#define HIGHT  864
#define BULLET_Num 15//����ӵ�������
#define ENEMY_NUM  20//�л�������
int bullet_rank = 0;//ս���ӵ��ĵȼ�
int score = 0;//�÷�
enum My
{
	BIG,
	SMALL
};
struct plance//�ɻ��ṹ
{
	int x;
	int y;
	bool live;//�Ƿ���
	int width;//�л��Ŀ�
	int height;//�л��ĸ߶�
	int hp;//�л�Ѫ��
	int type;//�л�����
}player, bull[BULLET_Num], enemy[ENEMY_NUM], PlanExplode;


 //int boss.w = 200;
 //int boss.h = 213;
 // int   boss.life = 100;
 // int boss.add_x = 2;
 // int boss.add_y = 1;
 // int 	
 // int 


IMAGE imgBack;  //��ű���ͼƬ
IMAGE img_role[2];    //ͼƬ����,�������ս��ͼƬ�ļ�
IMAGE img_bull[3][3];//ͼƬ�������������ս���ӵ���Ƭ
IMAGE img_enemy[2][2];//ͼƬ������������ŵл���Ƭ
IMAGE img_boss[2];//ͼƬ�������������boss��Ƭ
IMAGE img_planExplode;
 

void loadImg()
{
	//װ�ر���ͼƬ�ļ���imgBack��
	loadimage(&imgBack, "��Ϸ����ͼ.png", WIDTH, HIGHT);
	//��ͼƬ�ļ�װ�� img_role ������
	loadimage(&img_role[0], "ս��ͼ��.jpg");//Դ��ͼ�ɻ�
	loadimage(&img_role[1], "ս��ͼһ.jpg");//��ʵͼƬ�ɻ�
	//���л�ͼƬ�ļ����ص�img_enemy��
	loadimage(&img_enemy[0][0], "�л�2.0.jpg");
	loadimage(&img_enemy[0][1], "�л�2.jpg");
	loadimage(&img_enemy[1][0], "�л�ͼ��.jpg");
	loadimage(&img_enemy[1][1], "�л�ͼ��.1.jpg");
	//���ӵ�ͼƬ�ļ����ص�img_bull��
	loadimage(&img_bull[0][0], "�ӵ�ͼ1.jpg");
	loadimage(&img_bull[0][1], "�ӵ�ͼ2.jpg");
	loadimage(&img_bull[1][0], "�ӵ�2.jpg");
	loadimage(&img_bull[1][1], "�ӵ�2ԭͼ.jpg");
	loadimage(&img_bull[2][0], "�ӵ���.jpg");
	loadimage(&img_bull[2][1], "�ӵ���ԭͼ.jpg");
	//���ɻ���ըͼƬ�ļ����ص�img_planExplode��
	loadimage(&img_planExplode, "��ը.jpg");
}






void enemyHP(int j)//�ɻ����ຯ��
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
void gameInit()//��Ϸ��ʼ������
{
	int i;
	int j;
	loadImg();//����Ϸ�������ص�ͼ���豸���ڴ�
	mciSendString(_T("play ������-����ֻ�ܻ�ζ.mp3 repeat"), NULL, 0, NULL);
	player.x = WIDTH / 2 - 48;
	player.y = HIGHT - 150;
	PlanExplode.x = -700;
	PlanExplode.y = 0;
	//boss.x = WIDTH / 2 - boss.w / 2;
	//boss.y = -213;
	for (i = 0; i < BULLET_Num; i++)//��ʼ���ӵ�
	{
		bull[i].x = 0;
		bull[i].y = 0;
		bull[i].live = false;
	}
	//��ʼ���л�
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
	//��imgBack���Ƶ�ָ������λ��
	putimage(0, 0, &imgBack);
	//��img_role���Ƶ�ָ������λ�ã���Դ��ͼ����ԭͼ
		player.live = true;
		putimage(player.x, player.y, &img_role[0], NOTSRCERASE);
		putimage(player.x, player.y, &img_role[1], SRCINVERT);
		putimage(PlanExplode.x, PlanExplode.y, &img_planExplode);
	for (i = 0; i < BULLET_Num; i++)//�����ӵ�
	{
		if (bull[i].live)
		{
			putimage(bull[i].x, bull[i].y, &img_bull[bullet_rank][0], NOTSRCERASE);
			putimage(bull[i].x, bull[i].y, &img_bull[bullet_rank][1], SRCINVERT);
		}
	}
	for (j = 0; j < ENEMY_NUM; j++)//���Ƶл�
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
void createBullet()//�����ӵ���һ��ʼ��ʼ����ʱ���ӵ�û�е�
{
	int i;
	for (i = 0; i < BULLET_Num; i++)
	{
		if (!bull[i].live)
		{
			if (bullet_rank == 0)
			{
				bull[i].x = player.x + 45;//�����ӵ�������
				bull[i].y = player.y;//�����ӵ�������
				bull[i].live = true;
				break;
			}
			else if (bullet_rank == 1)
			{
				bull[i].x = player.x + 30;//�����ӵ�������
				bull[i].y = player.y;//�����ӵ�������
				bull[i].live = true;
				break;
			}
			else if (bullet_rank == 2)
			{
				bull[i].x = player.x + 20;//�����ӵ�������
				bull[i].y = player.y;//�����ӵ�������
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

bool Timer(int ms, int id)//��ʱ������
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
		mciSendString(_T("play �ӵ�����.mp3 "), NULL, 0, NULL);
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
				mciSendString(_T("play ��ը��.mp3 "), NULL, 0, NULL);
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
	initgraph(WIDTH, HIGHT); //��ʼ��ͼ���豸
	gameInit();
	BeginBatchDraw();//˫�����ͼ
	while (1)
	{
		gameDraw();//����Ϸ���������ͼ�ν���
		FlushBatchDraw();//ˢ�»�ȡͼƬ
		playerMove(1);
		BulletMove(3);
		//BossMove(1);//Boss�ƶ�
		if (Timer(500, 1))
		{
			createEnemy();//����л�
		}
		if (Timer(8, 2))
		{
			enemyMove(1);//�л��ƶ�
		}
		playPlance();//��ɻ�����
	}
	EndBatchDraw();
	closegraph();//�ر�ͼ���豸
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
	
	initgraph(640, 480);//��ʼ��ͼ���豸
	loadimage(&imgBack, "��Ϸ����2.jpg", 640, 480);//װ�ر���ͼƬ�ļ���imBack��
	xCar = 300;
	yCar = 200;
	xPlane = 640;
	yPlane = 0;
	loadimage(&img, "���ճ�.bmp");
	loadimage(&imgPlane, "plane2.bmp");
	putimage(0, 0, &imgBack);
	//��img���Ƶ�ָ������λ��
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
		Init();//��ʼ��Ϸ����
		Diplan();
		PlaneMove();

	}
	//�ر�ͼ���豸
	closegraph();
}
*/
