create database angelshop charset utf8;/*创建数据库angelshop*/
use angelshop;

create table clothes/*创建产品表clothes*/
(
  clotheID int(20) auto_increment not null primary key,/*货号*/
  clotheName varchar(100) not null,
  origin varchar(20) not null,/*发货地*/
  style varchar(20) not null,/*风格*/
  color varchar(20) not null,/*颜色*/
  deliveryTime varchar(20) not null,/*发货时间*/
  price double(7,2) unsigned not null,
  discount double(3,2) unsigned not null,
  cover  varchar(50)  comment '封面图片的url',
  type    varchar(50) not null, 
  content varchar(1000) 
)AUTO_INCREMENT=00820001;/*设置主键的起始数值*/

create table customer/*创建用户表customer*/
(
  account varchar(20) not null primary key,
  pwd varchar(100) not null,
  phone char(20) not null,
  address varchar(50) not null
);

create table cart/*创建购物车表*/
(
  cartID int(20) auto_increment not null primary key,
  clotheID int(20) not null,
  account varchar(20) not null,
  quantity smallint unsigned not null,
  createTime datetime not null,
  updateTime datetime not null,
  foreign key(account) references customer(account) on delete cascade on update cascade,
  foreign key(clotheID) references clothes(clotheID) on delete cascade on update cascade
);

create table orders/*创建订单表*/
(
  orderID char(15) not null primary key,
  account varchar(20) not null,
  total double(8,2) not null,
  deliverWay varchar(25) not null,/*发货方式*/
  paymentWay varchar(25) not null,/*支付方式*/
  orderTime datetime not null,
  orderState varchar(10) not null default "待审核",/*订单状态*/
  foreign key(account) references customer(account) on delete cascade on update cascade
);

create table suborders(
  suborderID int unsigned auto_increment not null primary key,
  clotheID int(20) not null,
  orderID char(15) not null,
  count int not null,
  foreign key(orderID) references orders(orderID) on delete cascade on update cascade
);

insert into clothes values(null,'蓝色洋气钢琴演出服高端走秀拖尾公主裙蓬蓬纱', '广东-广州','公主','蓝色','7天内发货', 499.00,0.85,'images/a1.jpg','长款服装','从设计到工艺，从思考到原料，我们每一个环节都是精致细心，优雅的浅蓝色，一字肩设计款，梦幻般唯美，女孩的公主梦，我们替您实现。裙子胸前唯美的设计，可以拉长颈部线条，华丽的色彩、蓬松下垂的优雅版型衬出高贵优雅、利落的裁剪、手工缝制，腰带束身设计可以休身立体，让您化身美丽精灵。');
insert into clothes values(null,'粉色公主裙洋气主持人钢琴演出服走秀蓬蓬裙', '广东-广州','公主','粉色','7天内发货', 349.00,0.88,'images/b1.jpg','长款服装','浪漫的粉色，时尚的蓬蓬裙，加上立体的裁剪，衬托出你的优雅气质，这是一款柔美又不失性感的礼服裙，粉色的裙摆加上独特的领部设计，后背拉链设计的简单方便，让你在舞台上走路自带美感，绽放耀眼的光芒。');
insert into clothes values(null,'新款礼服公主裙高端模特走秀女孩气质钢琴比赛演出服', '广东-广州','公主','金色','7天内发货', 459.00,0.85,'images/c1.jpg','长款服装','华丽的金色，在胸前镶上高端定制制作的水钻，彰显唯美设计，拉长颈部线条，人工细心缝制的细心走线和优雅蓬松的版型将衬出您的优雅高贵，让你在人群中光芒万绽，化身美丽精灵。');
insert into clothes values(null,'红色高端走秀洋气公主裙女孩婚礼钢琴演出服蓬蓬裙', '广东-广州','公主','红色','7天内发货', 498.00,0.85,'images/d1.jpg','长款服装','高贵大气的红色让人眼前一亮，裙子胸前唯美的设计，加上高端定制的水钻，人工细心的缝制，不仅可以拉长颈部线条，而且让上半身惊艳脱俗，细致的走线，大气高贵的色彩、长款纱状垂感设计衬出您的高贵优雅，优雅的版型、利落的裁剪、手工缝制，腰带束身设计可以休身立体，让您如置身于童话王国');
insert into clothes values(null,'礼服女走秀洋气公主裙女孩婚纱主持钢琴演出服蓬蓬裙', '广东-广州','公主','灰色','7天内发货', 599.00,0.87,'images/e1.jpg','长款服装','高贵大气的灰色纱裙配上金黄色的钻石，让色彩十分出众，让人眼前一亮。加上一字肩的设计，完美彰显肩部线条，拉长颈部线条，华丽的色彩、蓬松下垂的优雅版型衬出高贵优雅、利落的裁剪、手工缝制，腰带束身设计可以休身立体让您穿上梦幻般唯美，当舞台上最出彩的公主。');
insert into clothes values(null,'金黄色礼服女洋气走秀公主裙女孩万圣节主持人钢琴演出服蓬蓬裙', '广东-广州','公主','金黄色','7天内发货', 699.00,0.85,'images/f1.jpg','长款服装','华丽高贵的金色纱裙配上人工定制的刺绣，如同锦上添花，在蓬蓬袖外叠加一层轻纱，完美地修饰肩部线条，整件裙子从设计到工艺，从思考到原料，每一步都是手工精心缝制，干净利落的线条设计、腰带束身设计可以休身立体，蓬松下垂的优雅版型衬出高贵优雅，背部交织的线条可以修饰背部线条，让您化身美丽精灵，如同置身童话世界。');
insert into clothes values(null,'黑白礼服女高端模特走秀公主裙女孩主持人蛋糕裙钢琴比赛演出服', '广东-广州','公主','黑白','7天内发货', 399.00,0.85,'images/g1.jpg','长款服装','上身采用贴近肤色涤纶面料，加上人工精心缝制的刺绣，镶上高端定制的珍珠，设计出色，版型优雅，能够很好衬托出您的优雅高贵，裙摆结合蛋糕设计的思想，叠合设计，利落的裁剪、手工缝制，腰带束身设计休身立体，蓬松下垂的优雅版型衬出您的完美身材，让您当舞台最耀眼的公主。');
insert into clothes values(null,'白色礼服女婚纱长款公主裙女孩主持人钢琴演出服秋冬', '广东-广州','公主','白色','7天内发货', 299.00,0.85,'images/h1.jpg','长款服装','采用高端网纱设计，加上人工精心缝制的刺绣，让裙子简单出众，从设计到工艺，从思考到原料，每一个环节都彰显精致细心，优雅的白色，蝴蝶腰身设计可以休身立体，蓬松下垂的优雅版型衬出高贵优雅、利落的裁剪、手工缝制，让美丽与舒服并存，能够完美彰显出众的气质，成为舞台上优雅美丽的精灵，引人瞩目。');
insert into clothes values(null,'亮片礼服女高端模特走秀洋气公主裙女孩生日主持人钢琴演出服', '广东-广州','公主','亮色','7天内发货', 899.00,0.88,'images/i1.jpg','长款服装','采用高端亮片色泽度极好的原材料制作，在灯光下光感饱和度好，实现强有力的舞台效果，一字肩设计加上鱼骨对肩部塑形处理，彰显肩部挺括有型，内部采用高强度弹力网，网纱纱织密度高、光泽度强、手感舒适，每一个环节都是精致细心的缝制，让您穿的优雅穿的舒适，化身舞台最光彩夺目的公主。');
insert into clothes values(null,'白色礼服女高端模特走秀白色公主裙女孩生日钢琴演出服拖尾蓬蓬裙', '广东-广州','公主','白色','7天内发货', 449.00,0.88,'images/j1.jpg','长款服装','V领低胸唯美的设计彰显公主的自信美丽，可以拉长颈部线条，采用高端网纱面料加上独特的印花设计，让裙子华丽出彩，从设计到工艺，从思考到原料，每一个环节都是手工一针一线缝制而成，高贵简洁的白色，梦幻般唯美，蓬松下垂的优雅版型衬出高贵优雅、利落的裁剪、手工缝制，腰带束身设计可以休身立体，女孩的公主梦，我们为您实现。');
insert into clothes values(null,'渐变色礼服女高端走秀洋气公主裙小女孩生日主持钢琴演出服蓬蓬裙', '广东-广州','公主','渐变色','7天内发货', 598.00,0.89,'images/k1.jpg','长款服装','胸前唯美的V领设计加上高端定制的钻石，完美彰显公主的自信美丽，独特的围脖设计可以拉长颈部线条，采用高端网纱面料加上独特的印花设计，在裙摆周边镶上飘逸的羽毛，让裙子华丽出彩，从设计到工艺，从思考到原料，我们每一个环节都经过精致细心的手工缝制，独特优美的渐变色，梦幻般唯美，让您成为舞台最亮的星星，实现自己的公主梦。');
/*从clothes表中查询所有的图书记录*/

select * from clothes;
