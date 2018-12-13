<template>
                    <Cascader v-model="weathercity" :data='data' change-on-select   @click='sendChildData'></Cascader>
  
</Modal>
</template>

<script>
  export default {
    name: 'WeaeherModel',
    props: {

    },
    data() {
      return {
        model1:false,
        weathercity:[],
        data: [{
            "value": 1,
            "label": "北京",
            "children": [{
                "value": 501,
                "label": "海淀区",
                "children": []
              },
              {
                "value": 502,
                "label": "朝阳区",
                "children": []
              },
              {
                "value": 505,
                "label": "丰台区",
                "children": []
              },
              {
                "value": 506,
                "label": "石景山区",
                "children": []
              },
              {
                "value": 507,
                "label": "房山区",
                "children": []
              },
              {
                "value": 508,
                "label": "门头沟区",
                "children": []
              },
              {
                "value": 509,
                "label": "通州区",
                "children": []
              },
              {
                "value": 510,
                "label": "顺义区",
                "children": []
              },
              {
                "value": 511,
                "label": "昌平区",
                "children": []
              },
              {
                "value": 512,
                "label": "怀柔区",
                "children": []
              },
              {
                "value": 513,
                "label": "平谷区",
                "children": []
              },
              {
                "value": 514,
                "label": "大兴区",
                "children": []
              },
              {
                "value": 515,
                "label": "密云县",
                "children": []
              },
              {
                "value": 516,
                "label": "延庆县",
                "children": []
              }
            ]
          },
          {
            "value": 2,
            "label": "安徽",
            "children": [{
                "value": 35,
                "label": "安庆",
                "children": [{
                    "value": 400,
                    "label": "桐城市",
                    "children": []
                  },
                  {
                    "value": 401,
                    "label": "怀宁县",
                    "children": []
                  },
                  {
                    "value": 403,
                    "label": "潜山县",
                    "children": []
                  },
                  {
                    "value": 404,
                    "label": "太湖县",
                    "children": []
                  },
                  {
                    "value": 405,
                    "label": "宿松县",
                    "children": []
                  },
                  {
                    "value": 406,
                    "label": "望江县",
                    "children": []
                  },
                  {
                    "value": 407,
                    "label": "岳西县",
                    "children": []
                  }
                ]
              },
              {
                "value": 36,
                "label": "蚌埠",
                "children": [{
                    "value": 412,
                    "label": "怀远县",
                    "children": []
                  },
                  {
                    "value": 413,
                    "label": "五河县",
                    "children": []
                  },
                  {
                    "value": 414,
                    "label": "固镇县",
                    "children": []
                  }
                ]
              },
              {
                "value": 38,
                "label": "池州",
                "children": [{
                    "value": 421,
                    "label": "东至县",
                    "children": []
                  },
                  {
                    "value": 422,
                    "label": "石台县",
                    "children": []
                  },
                  {
                    "value": 423,
                    "label": "青阳县",
                    "children": []
                  }
                ]
              },
              {
                "value": 39,
                "label": "滁州",
                "children": [{
                    "value": 426,
                    "label": "天长市",
                    "children": []
                  },
                  {
                    "value": 427,
                    "label": "明光市",
                    "children": []
                  },
                  {
                    "value": 428,
                    "label": "来安县",
                    "children": []
                  },
                  {
                    "value": 429,
                    "label": "全椒县",
                    "children": []
                  },
                  {
                    "value": 430,
                    "label": "定远县",
                    "children": []
                  },
                  {
                    "value": 431,
                    "label": "凤阳县",
                    "children": []
                  }
                ]
              },
              {
                "value": 40,
                "label": "阜阳",
                "children": [{
                    "value": 439,
                    "label": "界首市",
                    "children": []
                  },
                  {
                    "value": 440,
                    "label": "临泉县",
                    "children": []
                  },
                  {
                    "value": 441,
                    "label": "太和县",
                    "children": []
                  },
                  {
                    "value": 442,
                    "label": "阜南县",
                    "children": []
                  },
                  {
                    "value": 443,
                    "label": "颍上县",
                    "children": []
                  }
                ]
              },
              {
                "value": 41,
                "label": "淮北",
                "children": [{
                  "value": 447,
                  "label": "濉溪县",
                  "children": []
                }]
              },
              {
                "value": 42,
                "label": "淮南",
                "children": [{
                    "value": 452,
                    "label": "潘集区",
                    "children": []
                  },
                  {
                    "value": 453,
                    "label": "凤台县",
                    "children": []
                  }
                ]
              },
              {
                "value": 43,
                "label": "黄山",
                "children": [{
                    "value": 454,
                    "label": "屯溪区",
                    "children": []
                  },
                  {
                    "value": 455,
                    "label": "黄山区",
                    "children": []
                  },
                  {
                    "value": 457,
                    "label": "歙县",
                    "children": []
                  },
                  {
                    "value": 458,
                    "label": "休宁县",
                    "children": []
                  },
                  {
                    "value": 459,
                    "label": "黟县",
                    "children": []
                  },
                  {
                    "value": 460,
                    "label": "祁门县",
                    "children": []
                  }
                ]
              },
              {
                "value": 44,
                "label": "六安",
                "children": [{
                    "value": 463,
                    "label": "寿县",
                    "children": []
                  },
                  {
                    "value": 464,
                    "label": "霍邱县",
                    "children": []
                  },
                  {
                    "value": 465,
                    "label": "舒城县",
                    "children": []
                  },
                  {
                    "value": 466,
                    "label": "金寨县",
                    "children": []
                  },
                  {
                    "value": 467,
                    "label": "霍山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 45,
                "label": "马鞍山",
                "children": [{
                    "value": 418,
                    "label": "含山县",
                    "children": []
                  },
                  {
                    "value": 419,
                    "label": "和县",
                    "children": []
                  },
                  {
                    "value": 471,
                    "label": "当涂县",
                    "children": []
                  }
                ]
              },
              {
                "value": 46,
                "label": "宿州",
                "children": [{
                    "value": 473,
                    "label": "砀山县",
                    "children": []
                  },
                  {
                    "value": 474,
                    "label": "萧县",
                    "children": []
                  },
                  {
                    "value": 475,
                    "label": "灵璧县",
                    "children": []
                  },
                  {
                    "value": 476,
                    "label": "泗县",
                    "children": []
                  }
                ]
              },
              {
                "value": 47,
                "label": "铜陵",
                "children": [{
                    "value": 402,
                    "label": "枞阳县",
                    "children": []
                  },
                  {
                    "value": 480,
                    "label": "义安区",
                    "children": []
                  }
                ]
              },
              {
                "value": 48,
                "label": "芜湖",
                "children": [{
                    "value": 417,
                    "label": "无为县",
                    "children": []
                  },
                  {
                    "value": 485,
                    "label": "芜湖县",
                    "children": []
                  },
                  {
                    "value": 486,
                    "label": "繁昌县",
                    "children": []
                  },
                  {
                    "value": 487,
                    "label": "南陵县",
                    "children": []
                  }
                ]
              },
              {
                "value": 49,
                "label": "宣城",
                "children": [{
                    "value": 489,
                    "label": "宁国市",
                    "children": []
                  },
                  {
                    "value": 490,
                    "label": "郎溪县",
                    "children": []
                  },
                  {
                    "value": 491,
                    "label": "广德县",
                    "children": []
                  },
                  {
                    "value": 492,
                    "label": "泾县",
                    "children": []
                  },
                  {
                    "value": 493,
                    "label": "绩溪县",
                    "children": []
                  },
                  {
                    "value": 494,
                    "label": "旌德县",
                    "children": []
                  }
                ]
              },
              {
                "value": 50,
                "label": "亳州",
                "children": [{
                    "value": 495,
                    "label": "涡阳县",
                    "children": []
                  },
                  {
                    "value": 496,
                    "label": "蒙城县",
                    "children": []
                  },
                  {
                    "value": 497,
                    "label": "利辛县",
                    "children": []
                  }
                ]
              },
              {
                "value": 3400,
                "label": "合肥",
                "children": [{
                    "value": 37,
                    "label": "巢湖市",
                    "children": []
                  },
                  {
                    "value": 416,
                    "label": "庐江县",
                    "children": []
                  },
                  {
                    "value": 3405,
                    "label": "长丰县",
                    "children": []
                  },
                  {
                    "value": 3406,
                    "label": "肥东县",
                    "children": []
                  },
                  {
                    "value": 3407,
                    "label": "肥西县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 3,
            "label": "福建",
            "children": [{
                "value": 52,
                "label": "福州",
                "children": [{
                    "value": 522,
                    "label": "福清市",
                    "children": []
                  },
                  {
                    "value": 523,
                    "label": "长乐市",
                    "children": []
                  },
                  {
                    "value": 524,
                    "label": "闽侯县",
                    "children": []
                  },
                  {
                    "value": 525,
                    "label": "连江县",
                    "children": []
                  },
                  {
                    "value": 526,
                    "label": "罗源县",
                    "children": []
                  },
                  {
                    "value": 527,
                    "label": "闽清县",
                    "children": []
                  },
                  {
                    "value": 528,
                    "label": "永泰县",
                    "children": []
                  },
                  {
                    "value": 529,
                    "label": "平潭县",
                    "children": []
                  }
                ]
              },
              {
                "value": 53,
                "label": "龙岩",
                "children": [{
                    "value": 531,
                    "label": "漳平市",
                    "children": []
                  },
                  {
                    "value": 532,
                    "label": "长汀县",
                    "children": []
                  },
                  {
                    "value": 533,
                    "label": "永定县",
                    "children": []
                  },
                  {
                    "value": 534,
                    "label": "上杭县",
                    "children": []
                  },
                  {
                    "value": 535,
                    "label": "武平县",
                    "children": []
                  },
                  {
                    "value": 536,
                    "label": "连城县",
                    "children": []
                  }
                ]
              },
              {
                "value": 54,
                "label": "南平",
                "children": [{
                    "value": 538,
                    "label": "邵武市",
                    "children": []
                  },
                  {
                    "value": 539,
                    "label": "武夷山市",
                    "children": []
                  },
                  {
                    "value": 540,
                    "label": "建瓯市",
                    "children": []
                  },
                  {
                    "value": 541,
                    "label": "建阳市",
                    "children": []
                  },
                  {
                    "value": 542,
                    "label": "顺昌县",
                    "children": []
                  },
                  {
                    "value": 543,
                    "label": "浦城县",
                    "children": []
                  },
                  {
                    "value": 544,
                    "label": "光泽县",
                    "children": []
                  },
                  {
                    "value": 545,
                    "label": "松溪县",
                    "children": []
                  },
                  {
                    "value": 546,
                    "label": "政和县",
                    "children": []
                  }
                ]
              },
              {
                "value": 55,
                "label": "宁德",
                "children": [{
                    "value": 548,
                    "label": "福安市",
                    "children": []
                  },
                  {
                    "value": 549,
                    "label": "福鼎市",
                    "children": []
                  },
                  {
                    "value": 550,
                    "label": "霞浦县",
                    "children": []
                  },
                  {
                    "value": 551,
                    "label": "古田县",
                    "children": []
                  },
                  {
                    "value": 552,
                    "label": "屏南县",
                    "children": []
                  },
                  {
                    "value": 553,
                    "label": "寿宁县",
                    "children": []
                  },
                  {
                    "value": 554,
                    "label": "周宁县",
                    "children": []
                  },
                  {
                    "value": 555,
                    "label": "柘荣县",
                    "children": []
                  }
                ]
              },
              {
                "value": 56,
                "label": "莆田",
                "children": [{
                    "value": 556,
                    "label": "城厢区",
                    "children": []
                  },
                  {
                    "value": 557,
                    "label": "涵江区",
                    "children": []
                  },
                  {
                    "value": 558,
                    "label": "荔城区",
                    "children": []
                  },
                  {
                    "value": 559,
                    "label": "秀屿区",
                    "children": []
                  },
                  {
                    "value": 560,
                    "label": "仙游县",
                    "children": []
                  }
                ]
              },
              {
                "value": 57,
                "label": "泉州",
                "children": [{
                    "value": 566,
                    "label": "石狮市",
                    "children": []
                  },
                  {
                    "value": 567,
                    "label": "晋江市",
                    "children": []
                  },
                  {
                    "value": 568,
                    "label": "南安市",
                    "children": []
                  },
                  {
                    "value": 569,
                    "label": "惠安县",
                    "children": []
                  },
                  {
                    "value": 570,
                    "label": "安溪县",
                    "children": []
                  },
                  {
                    "value": 571,
                    "label": "永春县",
                    "children": []
                  },
                  {
                    "value": 572,
                    "label": "德化县",
                    "children": []
                  }
                ]
              },
              {
                "value": 58,
                "label": "三明",
                "children": [{
                    "value": 576,
                    "label": "永安市",
                    "children": []
                  },
                  {
                    "value": 577,
                    "label": "明溪县",
                    "children": []
                  },
                  {
                    "value": 578,
                    "label": "清流县",
                    "children": []
                  },
                  {
                    "value": 579,
                    "label": "宁化县",
                    "children": []
                  },
                  {
                    "value": 580,
                    "label": "大田县",
                    "children": []
                  },
                  {
                    "value": 581,
                    "label": "尤溪县",
                    "children": []
                  },
                  {
                    "value": 582,
                    "label": "沙县",
                    "children": []
                  },
                  {
                    "value": 583,
                    "label": "将乐县",
                    "children": []
                  },
                  {
                    "value": 584,
                    "label": "泰宁县",
                    "children": []
                  },
                  {
                    "value": 585,
                    "label": "建宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 59,
                "label": "厦门",
                "children": [{
                  "value": 590,
                  "label": "同安区",
                  "children": []
                }]
              },
              {
                "value": 60,
                "label": "漳州",
                "children": [{
                    "value": 594,
                    "label": "龙海市",
                    "children": []
                  },
                  {
                    "value": 595,
                    "label": "云霄县",
                    "children": []
                  },
                  {
                    "value": 596,
                    "label": "漳浦县",
                    "children": []
                  },
                  {
                    "value": 597,
                    "label": "诏安县",
                    "children": []
                  },
                  {
                    "value": 598,
                    "label": "长泰县",
                    "children": []
                  },
                  {
                    "value": 599,
                    "label": "东山县",
                    "children": []
                  },
                  {
                    "value": 600,
                    "label": "南靖县",
                    "children": []
                  },
                  {
                    "value": 601,
                    "label": "平和县",
                    "children": []
                  },
                  {
                    "value": 602,
                    "label": "华安县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 4,
            "label": "甘肃",
            "children": [{
                "value": 61,
                "label": "兰州",
                "children": [{
                    "value": 603,
                    "label": "皋兰县",
                    "children": []
                  },
                  {
                    "value": 609,
                    "label": "永登县",
                    "children": []
                  },
                  {
                    "value": 610,
                    "label": "榆中县",
                    "children": []
                  }
                ]
              },
              {
                "value": 62,
                "label": "白银",
                "children": [{
                    "value": 611,
                    "label": "白银区",
                    "children": []
                  },
                  {
                    "value": 612,
                    "label": "平川区",
                    "children": []
                  },
                  {
                    "value": 613,
                    "label": "会宁县",
                    "children": []
                  },
                  {
                    "value": 614,
                    "label": "景泰县",
                    "children": []
                  },
                  {
                    "value": 615,
                    "label": "靖远县",
                    "children": []
                  }
                ]
              },
              {
                "value": 63,
                "label": "定西",
                "children": [{
                    "value": 616,
                    "label": "临洮县",
                    "children": []
                  },
                  {
                    "value": 617,
                    "label": "陇西县",
                    "children": []
                  },
                  {
                    "value": 618,
                    "label": "通渭县",
                    "children": []
                  },
                  {
                    "value": 619,
                    "label": "渭源县",
                    "children": []
                  },
                  {
                    "value": 620,
                    "label": "漳县",
                    "children": []
                  },
                  {
                    "value": 621,
                    "label": "岷县",
                    "children": []
                  }
                ]
              },
              {
                "value": 64,
                "label": "甘南州",
                "children": [{
                    "value": 624,
                    "label": "合作市",
                    "children": []
                  },
                  {
                    "value": 625,
                    "label": "临潭县",
                    "children": []
                  },
                  {
                    "value": 626,
                    "label": "卓尼县",
                    "children": []
                  },
                  {
                    "value": 627,
                    "label": "舟曲县",
                    "children": []
                  },
                  {
                    "value": 628,
                    "label": "迭部县",
                    "children": []
                  },
                  {
                    "value": 629,
                    "label": "玛曲县",
                    "children": []
                  },
                  {
                    "value": 630,
                    "label": "碌曲县",
                    "children": []
                  },
                  {
                    "value": 631,
                    "label": "夏河县",
                    "children": []
                  }
                ]
              },
              {
                "value": 65,
                "label": "嘉峪关",
                "children": []
              },
              {
                "value": 66,
                "label": "金昌",
                "children": [{
                  "value": 634,
                  "label": "永昌县",
                  "children": []
                }]
              },
              {
                "value": 67,
                "label": "酒泉",
                "children": [{
                    "value": 636,
                    "label": "玉门市",
                    "children": []
                  },
                  {
                    "value": 637,
                    "label": "敦煌市",
                    "children": []
                  },
                  {
                    "value": 638,
                    "label": "金塔县",
                    "children": []
                  },
                  {
                    "value": 639,
                    "label": "瓜州县",
                    "children": []
                  },
                  {
                    "value": 640,
                    "label": "肃北县",
                    "children": []
                  },
                  {
                    "value": 641,
                    "label": "阿克塞",
                    "children": []
                  }
                ]
              },
              {
                "value": 68,
                "label": "临夏",
                "children": [{
                    "value": 642,
                    "label": "临夏市",
                    "children": []
                  },
                  {
                    "value": 643,
                    "label": "临夏县",
                    "children": []
                  },
                  {
                    "value": 644,
                    "label": "康乐县",
                    "children": []
                  },
                  {
                    "value": 645,
                    "label": "永靖县",
                    "children": []
                  },
                  {
                    "value": 646,
                    "label": "广河县",
                    "children": []
                  },
                  {
                    "value": 647,
                    "label": "和政县",
                    "children": []
                  },
                  {
                    "value": 648,
                    "label": "东乡族自治县",
                    "children": []
                  },
                  {
                    "value": 649,
                    "label": "积石山",
                    "children": []
                  }
                ]
              },
              {
                "value": 69,
                "label": "陇南市",
                "children": [{
                    "value": 650,
                    "label": "成县",
                    "children": []
                  },
                  {
                    "value": 651,
                    "label": "徽县",
                    "children": []
                  },
                  {
                    "value": 652,
                    "label": "康县",
                    "children": []
                  },
                  {
                    "value": 653,
                    "label": "礼县",
                    "children": []
                  },
                  {
                    "value": 654,
                    "label": "两当县",
                    "children": []
                  },
                  {
                    "value": 655,
                    "label": "文县",
                    "children": []
                  },
                  {
                    "value": 656,
                    "label": "西和县",
                    "children": []
                  },
                  {
                    "value": 657,
                    "label": "宕昌县",
                    "children": []
                  },
                  {
                    "value": 658,
                    "label": "武都区",
                    "children": []
                  }
                ]
              },
              {
                "value": 70,
                "label": "平凉",
                "children": [{
                    "value": 659,
                    "label": "崇信县",
                    "children": []
                  },
                  {
                    "value": 660,
                    "label": "华亭县",
                    "children": []
                  },
                  {
                    "value": 661,
                    "label": "静宁县",
                    "children": []
                  },
                  {
                    "value": 662,
                    "label": "灵台县",
                    "children": []
                  },
                  {
                    "value": 663,
                    "label": "崆峒区",
                    "children": []
                  },
                  {
                    "value": 664,
                    "label": "庄浪县",
                    "children": []
                  },
                  {
                    "value": 665,
                    "label": "泾川县",
                    "children": []
                  }
                ]
              },
              {
                "value": 71,
                "label": "庆阳",
                "children": [{
                    "value": 666,
                    "label": "合水县",
                    "children": []
                  },
                  {
                    "value": 667,
                    "label": "华池县",
                    "children": []
                  },
                  {
                    "value": 668,
                    "label": "环县",
                    "children": []
                  },
                  {
                    "value": 669,
                    "label": "宁县",
                    "children": []
                  },
                  {
                    "value": 670,
                    "label": "庆城县",
                    "children": []
                  },
                  {
                    "value": 671,
                    "label": "西峰区",
                    "children": []
                  },
                  {
                    "value": 672,
                    "label": "镇原县",
                    "children": []
                  },
                  {
                    "value": 673,
                    "label": "正宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 72,
                "label": "天水",
                "children": [{
                    "value": 674,
                    "label": "甘谷县",
                    "children": []
                  },
                  {
                    "value": 675,
                    "label": "秦安县",
                    "children": []
                  },
                  {
                    "value": 676,
                    "label": "清水县",
                    "children": []
                  },
                  {
                    "value": 678,
                    "label": "麦积区",
                    "children": []
                  },
                  {
                    "value": 679,
                    "label": "武山县",
                    "children": []
                  },
                  {
                    "value": 680,
                    "label": "张家川",
                    "children": []
                  }
                ]
              },
              {
                "value": 73,
                "label": "武威",
                "children": [{
                    "value": 681,
                    "label": "古浪县",
                    "children": []
                  },
                  {
                    "value": 682,
                    "label": "民勤县",
                    "children": []
                  },
                  {
                    "value": 683,
                    "label": "天祝县",
                    "children": []
                  }
                ]
              },
              {
                "value": 74,
                "label": "张掖",
                "children": [{
                    "value": 685,
                    "label": "高台县",
                    "children": []
                  },
                  {
                    "value": 686,
                    "label": "临泽县",
                    "children": []
                  },
                  {
                    "value": 687,
                    "label": "民乐县",
                    "children": []
                  },
                  {
                    "value": 688,
                    "label": "山丹县",
                    "children": []
                  },
                  {
                    "value": 689,
                    "label": "肃南县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 5,
            "label": "广东",
            "children": [{
                "value": 75,
                "label": "广州",
                "children": [{
                    "value": 691,
                    "label": "从化区",
                    "children": []
                  },
                  {
                    "value": 692,
                    "label": "天河区",
                    "children": []
                  },
                  {
                    "value": 699,
                    "label": "番禺区",
                    "children": []
                  },
                  {
                    "value": 700,
                    "label": "花都区",
                    "children": []
                  },
                  {
                    "value": 701,
                    "label": "增城区",
                    "children": []
                  }
                ]
              },
              {
                "value": 76,
                "label": "深圳",
                "children": [{
                  "value": 706,
                  "label": "南山区",
                  "children": []
                }]
              },
              {
                "value": 77,
                "label": "潮州",
                "children": [{
                    "value": 711,
                    "label": "潮安县",
                    "children": []
                  },
                  {
                    "value": 712,
                    "label": "饶平县",
                    "children": []
                  }
                ]
              },
              {
                "value": 78,
                "label": "东莞",
                "children": []
              },
              {
                "value": 79,
                "label": "佛山",
                "children": [{
                    "value": 746,
                    "label": "南海区",
                    "children": []
                  },
                  {
                    "value": 747,
                    "label": "顺德区",
                    "children": []
                  },
                  {
                    "value": 748,
                    "label": "三水区",
                    "children": []
                  },
                  {
                    "value": 749,
                    "label": "高明区",
                    "children": []
                  }
                ]
              },
              {
                "value": 80,
                "label": "河源",
                "children": [{
                    "value": 750,
                    "label": "东源县",
                    "children": []
                  },
                  {
                    "value": 751,
                    "label": "和平县",
                    "children": []
                  },
                  {
                    "value": 753,
                    "label": "连平县",
                    "children": []
                  },
                  {
                    "value": 754,
                    "label": "龙川县",
                    "children": []
                  },
                  {
                    "value": 755,
                    "label": "紫金县",
                    "children": []
                  }
                ]
              },
              {
                "value": 81,
                "label": "惠州",
                "children": [{
                    "value": 756,
                    "label": "惠阳区",
                    "children": []
                  },
                  {
                    "value": 759,
                    "label": "博罗县",
                    "children": []
                  },
                  {
                    "value": 760,
                    "label": "惠东县",
                    "children": []
                  },
                  {
                    "value": 761,
                    "label": "龙门县",
                    "children": []
                  }
                ]
              },
              {
                "value": 82,
                "label": "江门",
                "children": [{
                    "value": 762,
                    "label": "江海区",
                    "children": []
                  },
                  {
                    "value": 763,
                    "label": "蓬江区",
                    "children": []
                  },
                  {
                    "value": 764,
                    "label": "新会区",
                    "children": []
                  },
                  {
                    "value": 765,
                    "label": "台山市",
                    "children": []
                  },
                  {
                    "value": 766,
                    "label": "开平市",
                    "children": []
                  },
                  {
                    "value": 767,
                    "label": "鹤山市",
                    "children": []
                  },
                  {
                    "value": 768,
                    "label": "恩平市",
                    "children": []
                  }
                ]
              },
              {
                "value": 83,
                "label": "揭阳",
                "children": [{
                    "value": 770,
                    "label": "普宁市",
                    "children": []
                  },
                  {
                    "value": 771,
                    "label": "揭东县",
                    "children": []
                  },
                  {
                    "value": 772,
                    "label": "揭西县",
                    "children": []
                  },
                  {
                    "value": 773,
                    "label": "惠来县",
                    "children": []
                  }
                ]
              },
              {
                "value": 84,
                "label": "茂名",
                "children": [{
                    "value": 775,
                    "label": "茂港区",
                    "children": []
                  },
                  {
                    "value": 776,
                    "label": "高州市",
                    "children": []
                  },
                  {
                    "value": 777,
                    "label": "化州市",
                    "children": []
                  },
                  {
                    "value": 778,
                    "label": "信宜市",
                    "children": []
                  },
                  {
                    "value": 779,
                    "label": "电白县",
                    "children": []
                  }
                ]
              },
              {
                "value": 85,
                "label": "梅州",
                "children": [{
                    "value": 780,
                    "label": "梅县",
                    "children": []
                  },
                  {
                    "value": 782,
                    "label": "兴宁市",
                    "children": []
                  },
                  {
                    "value": 783,
                    "label": "大埔县",
                    "children": []
                  },
                  {
                    "value": 784,
                    "label": "丰顺县",
                    "children": []
                  },
                  {
                    "value": 785,
                    "label": "五华县",
                    "children": []
                  },
                  {
                    "value": 786,
                    "label": "平远县",
                    "children": []
                  },
                  {
                    "value": 787,
                    "label": "蕉岭县",
                    "children": []
                  }
                ]
              },
              {
                "value": 86,
                "label": "清远",
                "children": [{
                    "value": 789,
                    "label": "英德市",
                    "children": []
                  },
                  {
                    "value": 790,
                    "label": "连州市",
                    "children": []
                  },
                  {
                    "value": 791,
                    "label": "佛冈县",
                    "children": []
                  },
                  {
                    "value": 792,
                    "label": "阳山县",
                    "children": []
                  },
                  {
                    "value": 793,
                    "label": "清新县",
                    "children": []
                  },
                  {
                    "value": 794,
                    "label": "连山县",
                    "children": []
                  },
                  {
                    "value": 795,
                    "label": "连南县",
                    "children": []
                  }
                ]
              },
              {
                "value": 87,
                "label": "汕头",
                "children": [{
                    "value": 796,
                    "label": "南澳县",
                    "children": []
                  },
                  {
                    "value": 797,
                    "label": "潮阳区",
                    "children": []
                  },
                  {
                    "value": 798,
                    "label": "澄海区",
                    "children": []
                  }
                ]
              },
              {
                "value": 88,
                "label": "汕尾",
                "children": [{
                    "value": 804,
                    "label": "陆丰市",
                    "children": []
                  },
                  {
                    "value": 805,
                    "label": "海丰县",
                    "children": []
                  },
                  {
                    "value": 806,
                    "label": "陆河县",
                    "children": []
                  }
                ]
              },
              {
                "value": 89,
                "label": "韶关",
                "children": [{
                    "value": 807,
                    "label": "曲江区",
                    "children": []
                  },
                  {
                    "value": 808,
                    "label": "浈江区",
                    "children": []
                  },
                  {
                    "value": 809,
                    "label": "武江区",
                    "children": []
                  },
                  {
                    "value": 810,
                    "label": "曲江区",
                    "children": []
                  },
                  {
                    "value": 811,
                    "label": "乐昌市",
                    "children": []
                  },
                  {
                    "value": 812,
                    "label": "南雄市",
                    "children": []
                  },
                  {
                    "value": 813,
                    "label": "始兴县",
                    "children": []
                  },
                  {
                    "value": 814,
                    "label": "仁化县",
                    "children": []
                  },
                  {
                    "value": 815,
                    "label": "翁源县",
                    "children": []
                  },
                  {
                    "value": 816,
                    "label": "新丰县",
                    "children": []
                  },
                  {
                    "value": 817,
                    "label": "乳源县",
                    "children": []
                  }
                ]
              },
              {
                "value": 90,
                "label": "阳江",
                "children": [{
                    "value": 819,
                    "label": "阳春市",
                    "children": []
                  },
                  {
                    "value": 820,
                    "label": "阳西县",
                    "children": []
                  },
                  {
                    "value": 821,
                    "label": "阳东县",
                    "children": []
                  }
                ]
              },
              {
                "value": 91,
                "label": "云浮",
                "children": [{
                    "value": 823,
                    "label": "罗定市",
                    "children": []
                  },
                  {
                    "value": 824,
                    "label": "新兴县",
                    "children": []
                  },
                  {
                    "value": 825,
                    "label": "郁南县",
                    "children": []
                  },
                  {
                    "value": 826,
                    "label": "云安县",
                    "children": []
                  }
                ]
              },
              {
                "value": 92,
                "label": "湛江",
                "children": [{
                    "value": 827,
                    "label": "赤坎区",
                    "children": []
                  },
                  {
                    "value": 828,
                    "label": "霞山区",
                    "children": []
                  },
                  {
                    "value": 829,
                    "label": "坡头区",
                    "children": []
                  },
                  {
                    "value": 830,
                    "label": "麻章区",
                    "children": []
                  },
                  {
                    "value": 831,
                    "label": "廉江市",
                    "children": []
                  },
                  {
                    "value": 832,
                    "label": "雷州市",
                    "children": []
                  },
                  {
                    "value": 833,
                    "label": "吴川市",
                    "children": []
                  },
                  {
                    "value": 834,
                    "label": "遂溪县",
                    "children": []
                  },
                  {
                    "value": 835,
                    "label": "徐闻县",
                    "children": []
                  }
                ]
              },
              {
                "value": 93,
                "label": "肇庆",
                "children": [{
                    "value": 837,
                    "label": "高要区",
                    "children": []
                  },
                  {
                    "value": 838,
                    "label": "四会市",
                    "children": []
                  },
                  {
                    "value": 839,
                    "label": "广宁县",
                    "children": []
                  },
                  {
                    "value": 840,
                    "label": "怀集县",
                    "children": []
                  },
                  {
                    "value": 841,
                    "label": "封开县",
                    "children": []
                  },
                  {
                    "value": 842,
                    "label": "德庆县",
                    "children": []
                  }
                ]
              },
              {
                "value": 94,
                "label": "中山",
                "children": []
              },
              {
                "value": 95,
                "label": "珠海",
                "children": [{
                    "value": 850,
                    "label": "斗门区",
                    "children": []
                  },
                  {
                    "value": 851,
                    "label": "金湾区",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 6,
            "label": "广西",
            "children": [{
                "value": 96,
                "label": "南宁",
                "children": [{
                    "value": 852,
                    "label": "邕宁区",
                    "children": []
                  },
                  {
                    "value": 858,
                    "label": "武鸣县",
                    "children": []
                  },
                  {
                    "value": 859,
                    "label": "隆安县",
                    "children": []
                  },
                  {
                    "value": 860,
                    "label": "马山县",
                    "children": []
                  },
                  {
                    "value": 861,
                    "label": "上林县",
                    "children": []
                  },
                  {
                    "value": 862,
                    "label": "宾阳县",
                    "children": []
                  },
                  {
                    "value": 863,
                    "label": "横县",
                    "children": []
                  }
                ]
              },
              {
                "value": 97,
                "label": "桂林",
                "children": [{
                    "value": 869,
                    "label": "阳朔县",
                    "children": []
                  },
                  {
                    "value": 870,
                    "label": "临桂县",
                    "children": []
                  },
                  {
                    "value": 871,
                    "label": "灵川县",
                    "children": []
                  },
                  {
                    "value": 872,
                    "label": "全州县",
                    "children": []
                  },
                  {
                    "value": 873,
                    "label": "平乐县",
                    "children": []
                  },
                  {
                    "value": 874,
                    "label": "兴安县",
                    "children": []
                  },
                  {
                    "value": 875,
                    "label": "灌阳县",
                    "children": []
                  },
                  {
                    "value": 876,
                    "label": "荔浦县",
                    "children": []
                  },
                  {
                    "value": 877,
                    "label": "资源县",
                    "children": []
                  },
                  {
                    "value": 878,
                    "label": "永福县",
                    "children": []
                  },
                  {
                    "value": 879,
                    "label": "龙胜县",
                    "children": []
                  },
                  {
                    "value": 880,
                    "label": "恭城县",
                    "children": []
                  }
                ]
              },
              {
                "value": 98,
                "label": "百色",
                "children": [{
                    "value": 882,
                    "label": "凌云县",
                    "children": []
                  },
                  {
                    "value": 883,
                    "label": "平果县",
                    "children": []
                  },
                  {
                    "value": 884,
                    "label": "西林县",
                    "children": []
                  },
                  {
                    "value": 885,
                    "label": "乐业县",
                    "children": []
                  },
                  {
                    "value": 886,
                    "label": "德保县",
                    "children": []
                  },
                  {
                    "value": 887,
                    "label": "田林县",
                    "children": []
                  },
                  {
                    "value": 888,
                    "label": "田阳县",
                    "children": []
                  },
                  {
                    "value": 889,
                    "label": "靖西县",
                    "children": []
                  },
                  {
                    "value": 890,
                    "label": "田东县",
                    "children": []
                  },
                  {
                    "value": 891,
                    "label": "那坡县",
                    "children": []
                  },
                  {
                    "value": 892,
                    "label": "隆林县",
                    "children": []
                  }
                ]
              },
              {
                "value": 99,
                "label": "北海",
                "children": [{
                  "value": 896,
                  "label": "合浦县",
                  "children": []
                }]
              },
              {
                "value": 100,
                "label": "崇左",
                "children": [{
                    "value": 898,
                    "label": "凭祥市",
                    "children": []
                  },
                  {
                    "value": 899,
                    "label": "宁明县",
                    "children": []
                  },
                  {
                    "value": 900,
                    "label": "扶绥县",
                    "children": []
                  },
                  {
                    "value": 901,
                    "label": "龙州县",
                    "children": []
                  },
                  {
                    "value": 902,
                    "label": "大新县",
                    "children": []
                  },
                  {
                    "value": 903,
                    "label": "天等县",
                    "children": []
                  }
                ]
              },
              {
                "value": 101,
                "label": "防城港",
                "children": [{
                    "value": 905,
                    "label": "防城区",
                    "children": []
                  },
                  {
                    "value": 906,
                    "label": "东兴市",
                    "children": []
                  },
                  {
                    "value": 907,
                    "label": "上思县",
                    "children": []
                  }
                ]
              },
              {
                "value": 102,
                "label": "贵港",
                "children": [{
                    "value": 911,
                    "label": "桂平市",
                    "children": []
                  },
                  {
                    "value": 912,
                    "label": "平南县",
                    "children": []
                  }
                ]
              },
              {
                "value": 103,
                "label": "河池",
                "children": [{
                    "value": 914,
                    "label": "宜州市",
                    "children": []
                  },
                  {
                    "value": 915,
                    "label": "天峨县",
                    "children": []
                  },
                  {
                    "value": 916,
                    "label": "凤山县",
                    "children": []
                  },
                  {
                    "value": 917,
                    "label": "南丹县",
                    "children": []
                  },
                  {
                    "value": 918,
                    "label": "东兰县",
                    "children": []
                  },
                  {
                    "value": 919,
                    "label": "都安县",
                    "children": []
                  },
                  {
                    "value": 920,
                    "label": "罗城县",
                    "children": []
                  },
                  {
                    "value": 921,
                    "label": "巴马县",
                    "children": []
                  },
                  {
                    "value": 922,
                    "label": "环江县",
                    "children": []
                  },
                  {
                    "value": 923,
                    "label": "大化县",
                    "children": []
                  }
                ]
              },
              {
                "value": 104,
                "label": "贺州",
                "children": [{
                    "value": 925,
                    "label": "钟山县",
                    "children": []
                  },
                  {
                    "value": 926,
                    "label": "昭平县",
                    "children": []
                  },
                  {
                    "value": 927,
                    "label": "富川县",
                    "children": []
                  }
                ]
              },
              {
                "value": 105,
                "label": "来宾",
                "children": [{
                    "value": 929,
                    "label": "合山市",
                    "children": []
                  },
                  {
                    "value": 930,
                    "label": "象州县",
                    "children": []
                  },
                  {
                    "value": 931,
                    "label": "武宣县",
                    "children": []
                  },
                  {
                    "value": 932,
                    "label": "忻城县",
                    "children": []
                  },
                  {
                    "value": 933,
                    "label": "金秀县",
                    "children": []
                  }
                ]
              },
              {
                "value": 106,
                "label": "柳州",
                "children": [{
                    "value": 938,
                    "label": "柳江县",
                    "children": []
                  },
                  {
                    "value": 939,
                    "label": "柳城县",
                    "children": []
                  },
                  {
                    "value": 940,
                    "label": "鹿寨县",
                    "children": []
                  },
                  {
                    "value": 941,
                    "label": "融安县",
                    "children": []
                  },
                  {
                    "value": 942,
                    "label": "融水县",
                    "children": []
                  },
                  {
                    "value": 943,
                    "label": "三江县",
                    "children": []
                  }
                ]
              },
              {
                "value": 107,
                "label": "钦州",
                "children": [{
                    "value": 946,
                    "label": "灵山县",
                    "children": []
                  },
                  {
                    "value": 947,
                    "label": "浦北县",
                    "children": []
                  }
                ]
              },
              {
                "value": 108,
                "label": "梧州",
                "children": [{
                    "value": 950,
                    "label": "长洲区",
                    "children": []
                  },
                  {
                    "value": 951,
                    "label": "岑溪市",
                    "children": []
                  },
                  {
                    "value": 952,
                    "label": "苍梧县",
                    "children": []
                  },
                  {
                    "value": 953,
                    "label": "藤县",
                    "children": []
                  },
                  {
                    "value": 954,
                    "label": "蒙山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 109,
                "label": "玉林",
                "children": [{
                    "value": 956,
                    "label": "北流市",
                    "children": []
                  },
                  {
                    "value": 957,
                    "label": "容县",
                    "children": []
                  },
                  {
                    "value": 958,
                    "label": "陆川县",
                    "children": []
                  },
                  {
                    "value": 959,
                    "label": "博白县",
                    "children": []
                  },
                  {
                    "value": 960,
                    "label": "兴业县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 7,
            "label": "贵州",
            "children": [{
                "value": 110,
                "label": "贵阳",
                "children": [{
                    "value": 961,
                    "label": "南明区",
                    "children": []
                  },
                  {
                    "value": 962,
                    "label": "云岩区",
                    "children": []
                  },
                  {
                    "value": 963,
                    "label": "花溪区",
                    "children": []
                  },
                  {
                    "value": 964,
                    "label": "乌当区",
                    "children": []
                  },
                  {
                    "value": 965,
                    "label": "白云区",
                    "children": []
                  },
                  {
                    "value": 966,
                    "label": "小河区",
                    "children": []
                  },
                  {
                    "value": 969,
                    "label": "清镇市",
                    "children": []
                  },
                  {
                    "value": 970,
                    "label": "开阳县",
                    "children": []
                  },
                  {
                    "value": 971,
                    "label": "修文县",
                    "children": []
                  },
                  {
                    "value": 972,
                    "label": "息烽县",
                    "children": []
                  }
                ]
              },
              {
                "value": 111,
                "label": "安顺",
                "children": [{
                    "value": 974,
                    "label": "关岭县",
                    "children": []
                  },
                  {
                    "value": 976,
                    "label": "紫云县",
                    "children": []
                  },
                  {
                    "value": 977,
                    "label": "平坝县",
                    "children": []
                  },
                  {
                    "value": 978,
                    "label": "普定县",
                    "children": []
                  }
                ]
              },
              {
                "value": 112,
                "label": "毕节",
                "children": [{
                    "value": 980,
                    "label": "大方县",
                    "children": []
                  },
                  {
                    "value": 981,
                    "label": "黔西县",
                    "children": []
                  },
                  {
                    "value": 982,
                    "label": "金沙县",
                    "children": []
                  },
                  {
                    "value": 983,
                    "label": "织金县",
                    "children": []
                  },
                  {
                    "value": 984,
                    "label": "纳雍县",
                    "children": []
                  },
                  {
                    "value": 985,
                    "label": "赫章县",
                    "children": []
                  },
                  {
                    "value": 986,
                    "label": "威宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 113,
                "label": "六盘水",
                "children": [{
                    "value": 989,
                    "label": "水城县",
                    "children": []
                  },
                  {
                    "value": 990,
                    "label": "盘县",
                    "children": []
                  }
                ]
              },
              {
                "value": 114,
                "label": "黔东南",
                "children": [{
                    "value": 991,
                    "label": "凯里市",
                    "children": []
                  },
                  {
                    "value": 992,
                    "label": "黄平县",
                    "children": []
                  },
                  {
                    "value": 993,
                    "label": "施秉县",
                    "children": []
                  },
                  {
                    "value": 994,
                    "label": "三穗县",
                    "children": []
                  },
                  {
                    "value": 995,
                    "label": "镇远县",
                    "children": []
                  },
                  {
                    "value": 996,
                    "label": "岑巩县",
                    "children": []
                  },
                  {
                    "value": 997,
                    "label": "天柱县",
                    "children": []
                  },
                  {
                    "value": 998,
                    "label": "锦屏县",
                    "children": []
                  },
                  {
                    "value": 999,
                    "label": "剑河县",
                    "children": []
                  },
                  {
                    "value": 1000,
                    "label": "台江县",
                    "children": []
                  },
                  {
                    "value": 1001,
                    "label": "黎平县",
                    "children": []
                  },
                  {
                    "value": 1002,
                    "label": "榕江县",
                    "children": []
                  },
                  {
                    "value": 1003,
                    "label": "从江县",
                    "children": []
                  },
                  {
                    "value": 1004,
                    "label": "雷山县",
                    "children": []
                  },
                  {
                    "value": 1005,
                    "label": "麻江县",
                    "children": []
                  },
                  {
                    "value": 1006,
                    "label": "丹寨县",
                    "children": []
                  }
                ]
              },
              {
                "value": 115,
                "label": "黔南",
                "children": [{
                    "value": 1007,
                    "label": "都匀市",
                    "children": []
                  },
                  {
                    "value": 1008,
                    "label": "福泉市",
                    "children": []
                  },
                  {
                    "value": 1009,
                    "label": "荔波县",
                    "children": []
                  },
                  {
                    "value": 1010,
                    "label": "贵定县",
                    "children": []
                  },
                  {
                    "value": 1011,
                    "label": "瓮安县",
                    "children": []
                  },
                  {
                    "value": 1012,
                    "label": "独山县",
                    "children": []
                  },
                  {
                    "value": 1013,
                    "label": "平塘县",
                    "children": []
                  },
                  {
                    "value": 1014,
                    "label": "罗甸县",
                    "children": []
                  },
                  {
                    "value": 1015,
                    "label": "长顺县",
                    "children": []
                  },
                  {
                    "value": 1016,
                    "label": "龙里县",
                    "children": []
                  },
                  {
                    "value": 1017,
                    "label": "惠水县",
                    "children": []
                  },
                  {
                    "value": 1018,
                    "label": "三都县",
                    "children": []
                  }
                ]
              },
              {
                "value": 116,
                "label": "黔西南",
                "children": [{
                    "value": 1019,
                    "label": "兴义市",
                    "children": []
                  },
                  {
                    "value": 1020,
                    "label": "兴仁县",
                    "children": []
                  },
                  {
                    "value": 1021,
                    "label": "普安县",
                    "children": []
                  },
                  {
                    "value": 1022,
                    "label": "晴隆县",
                    "children": []
                  },
                  {
                    "value": 1023,
                    "label": "贞丰县",
                    "children": []
                  },
                  {
                    "value": 1024,
                    "label": "望谟县",
                    "children": []
                  },
                  {
                    "value": 1025,
                    "label": "册亨县",
                    "children": []
                  },
                  {
                    "value": 1026,
                    "label": "安龙县",
                    "children": []
                  }
                ]
              },
              {
                "value": 117,
                "label": "铜仁",
                "children": [{
                    "value": 1027,
                    "label": "铜仁市",
                    "children": []
                  },
                  {
                    "value": 1028,
                    "label": "江口县",
                    "children": []
                  },
                  {
                    "value": 1029,
                    "label": "石阡县",
                    "children": []
                  },
                  {
                    "value": 1030,
                    "label": "思南县",
                    "children": []
                  },
                  {
                    "value": 1031,
                    "label": "德江县",
                    "children": []
                  },
                  {
                    "value": 1032,
                    "label": "玉屏县",
                    "children": []
                  },
                  {
                    "value": 1033,
                    "label": "印江县",
                    "children": []
                  },
                  {
                    "value": 1034,
                    "label": "沿河县",
                    "children": []
                  },
                  {
                    "value": 1035,
                    "label": "松桃县",
                    "children": []
                  }
                ]
              },
              {
                "value": 118,
                "label": "遵义",
                "children": [{
                    "value": 1037,
                    "label": "红花岗区",
                    "children": []
                  },
                  {
                    "value": 1038,
                    "label": "务川县",
                    "children": []
                  },
                  {
                    "value": 1039,
                    "label": "道真县",
                    "children": []
                  },
                  {
                    "value": 1040,
                    "label": "汇川区",
                    "children": []
                  },
                  {
                    "value": 1041,
                    "label": "赤水市",
                    "children": []
                  },
                  {
                    "value": 1042,
                    "label": "仁怀市",
                    "children": []
                  },
                  {
                    "value": 1043,
                    "label": "遵义县",
                    "children": []
                  },
                  {
                    "value": 1044,
                    "label": "桐梓县",
                    "children": []
                  },
                  {
                    "value": 1045,
                    "label": "绥阳县",
                    "children": []
                  },
                  {
                    "value": 1046,
                    "label": "正安县",
                    "children": []
                  },
                  {
                    "value": 1047,
                    "label": "凤冈县",
                    "children": []
                  },
                  {
                    "value": 1048,
                    "label": "湄潭县",
                    "children": []
                  },
                  {
                    "value": 1049,
                    "label": "余庆县",
                    "children": []
                  },
                  {
                    "value": 1050,
                    "label": "习水县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 8,
            "label": "海南",
            "children": [{
                "value": 119,
                "label": "海口",
                "children": [{
                  "value": 1055,
                  "label": "琼山区",
                  "children": []
                }]
              },
              {
                "value": 120,
                "label": "三亚",
                "children": []
              },
              {
                "value": 121,
                "label": "白沙县",
                "children": []
              },
              {
                "value": 122,
                "label": "保亭县",
                "children": []
              },
              {
                "value": 123,
                "label": "昌江县",
                "children": []
              },
              {
                "value": 124,
                "label": "澄迈县",
                "children": []
              },
              {
                "value": 125,
                "label": "定安县",
                "children": []
              },
              {
                "value": 126,
                "label": "东方",
                "children": []
              },
              {
                "value": 127,
                "label": "乐东县",
                "children": []
              },
              {
                "value": 128,
                "label": "临高县",
                "children": []
              },
              {
                "value": 129,
                "label": "陵水县",
                "children": []
              },
              {
                "value": 130,
                "label": "琼海",
                "children": []
              },
              {
                "value": 131,
                "label": "琼中",
                "children": []
              },
              {
                "value": 132,
                "label": "屯昌县",
                "children": []
              },
              {
                "value": 133,
                "label": "万宁",
                "children": []
              },
              {
                "value": 134,
                "label": "文昌",
                "children": []
              },
              {
                "value": 135,
                "label": "五指山",
                "children": []
              },
              {
                "value": 136,
                "label": "儋州",
                "children": []
              },
              {
                "value": 3661,
                "label": "三沙",
                "children": []
              }
            ]
          },
          {
            "value": 9,
            "label": "河北",
            "children": [{
                "value": 137,
                "label": "石家庄",
                "children": [{
                    "value": 1082,
                    "label": "井陉矿区",
                    "children": []
                  },
                  {
                    "value": 1084,
                    "label": "辛集市",
                    "children": []
                  },
                  {
                    "value": 1085,
                    "label": "藁城市",
                    "children": []
                  },
                  {
                    "value": 1086,
                    "label": "晋州市",
                    "children": []
                  },
                  {
                    "value": 1087,
                    "label": "新乐市",
                    "children": []
                  },
                  {
                    "value": 1088,
                    "label": "鹿泉区",
                    "children": []
                  },
                  {
                    "value": 1089,
                    "label": "井陉县",
                    "children": []
                  },
                  {
                    "value": 1090,
                    "label": "正定县",
                    "children": []
                  },
                  {
                    "value": 1091,
                    "label": "栾城区",
                    "children": []
                  },
                  {
                    "value": 1092,
                    "label": "行唐县",
                    "children": []
                  },
                  {
                    "value": 1093,
                    "label": "灵寿县",
                    "children": []
                  },
                  {
                    "value": 1094,
                    "label": "高邑县",
                    "children": []
                  },
                  {
                    "value": 1095,
                    "label": "深泽县",
                    "children": []
                  },
                  {
                    "value": 1096,
                    "label": "赞皇县",
                    "children": []
                  },
                  {
                    "value": 1097,
                    "label": "无极县",
                    "children": []
                  },
                  {
                    "value": 1098,
                    "label": "平山县",
                    "children": []
                  },
                  {
                    "value": 1099,
                    "label": "元氏县",
                    "children": []
                  },
                  {
                    "value": 1100,
                    "label": "赵县",
                    "children": []
                  }
                ]
              },
              {
                "value": 138,
                "label": "保定",
                "children": [{
                    "value": 1104,
                    "label": "涿州市",
                    "children": []
                  },
                  {
                    "value": 1105,
                    "label": "定州市",
                    "children": []
                  },
                  {
                    "value": 1106,
                    "label": "安国市",
                    "children": []
                  },
                  {
                    "value": 1107,
                    "label": "高碑店市",
                    "children": []
                  },
                  {
                    "value": 1108,
                    "label": "满城县",
                    "children": []
                  },
                  {
                    "value": 1109,
                    "label": "清苑县",
                    "children": []
                  },
                  {
                    "value": 1110,
                    "label": "涞水县",
                    "children": []
                  },
                  {
                    "value": 1111,
                    "label": "阜平县",
                    "children": []
                  },
                  {
                    "value": 1112,
                    "label": "徐水县",
                    "children": []
                  },
                  {
                    "value": 1113,
                    "label": "定兴县",
                    "children": []
                  },
                  {
                    "value": 1114,
                    "label": "唐县",
                    "children": []
                  },
                  {
                    "value": 1115,
                    "label": "高阳县",
                    "children": []
                  },
                  {
                    "value": 1116,
                    "label": "容城县",
                    "children": []
                  },
                  {
                    "value": 1117,
                    "label": "涞源县",
                    "children": []
                  },
                  {
                    "value": 1118,
                    "label": "望都县",
                    "children": []
                  },
                  {
                    "value": 1119,
                    "label": "安新县",
                    "children": []
                  },
                  {
                    "value": 1120,
                    "label": "易县",
                    "children": []
                  },
                  {
                    "value": 1121,
                    "label": "曲阳县",
                    "children": []
                  },
                  {
                    "value": 1122,
                    "label": "蠡县",
                    "children": []
                  },
                  {
                    "value": 1123,
                    "label": "顺平县",
                    "children": []
                  },
                  {
                    "value": 1124,
                    "label": "博野县",
                    "children": []
                  },
                  {
                    "value": 1125,
                    "label": "雄县",
                    "children": []
                  }
                ]
              },
              {
                "value": 139,
                "label": "沧州",
                "children": [{
                    "value": 1128,
                    "label": "泊头市",
                    "children": []
                  },
                  {
                    "value": 1129,
                    "label": "任丘市",
                    "children": []
                  },
                  {
                    "value": 1130,
                    "label": "黄骅市",
                    "children": []
                  },
                  {
                    "value": 1131,
                    "label": "河间市",
                    "children": []
                  },
                  {
                    "value": 1132,
                    "label": "沧县",
                    "children": []
                  },
                  {
                    "value": 1133,
                    "label": "青县",
                    "children": []
                  },
                  {
                    "value": 1134,
                    "label": "东光县",
                    "children": []
                  },
                  {
                    "value": 1135,
                    "label": "海兴县",
                    "children": []
                  },
                  {
                    "value": 1136,
                    "label": "盐山县",
                    "children": []
                  },
                  {
                    "value": 1137,
                    "label": "肃宁县",
                    "children": []
                  },
                  {
                    "value": 1138,
                    "label": "南皮县",
                    "children": []
                  },
                  {
                    "value": 1139,
                    "label": "吴桥县",
                    "children": []
                  },
                  {
                    "value": 1140,
                    "label": "献县",
                    "children": []
                  },
                  {
                    "value": 1141,
                    "label": "孟村县",
                    "children": []
                  }
                ]
              },
              {
                "value": 140,
                "label": "承德",
                "children": [{
                    "value": 1145,
                    "label": "承德县",
                    "children": []
                  },
                  {
                    "value": 1146,
                    "label": "兴隆县",
                    "children": []
                  },
                  {
                    "value": 1147,
                    "label": "平泉县",
                    "children": []
                  },
                  {
                    "value": 1148,
                    "label": "滦平县",
                    "children": []
                  },
                  {
                    "value": 1149,
                    "label": "隆化县",
                    "children": []
                  },
                  {
                    "value": 1150,
                    "label": "丰宁县",
                    "children": []
                  },
                  {
                    "value": 1151,
                    "label": "宽城县",
                    "children": []
                  },
                  {
                    "value": 1152,
                    "label": "围场县",
                    "children": []
                  }
                ]
              },
              {
                "value": 141,
                "label": "邯郸",
                "children": [{
                    "value": 1156,
                    "label": "峰峰矿区",
                    "children": []
                  },
                  {
                    "value": 1157,
                    "label": "武安市",
                    "children": []
                  },
                  {
                    "value": 1158,
                    "label": "邯郸县",
                    "children": []
                  },
                  {
                    "value": 1159,
                    "label": "临漳县",
                    "children": []
                  },
                  {
                    "value": 1160,
                    "label": "成安县",
                    "children": []
                  },
                  {
                    "value": 1161,
                    "label": "大名县",
                    "children": []
                  },
                  {
                    "value": 1162,
                    "label": "涉县",
                    "children": []
                  },
                  {
                    "value": 1163,
                    "label": "磁县",
                    "children": []
                  },
                  {
                    "value": 1164,
                    "label": "肥乡县",
                    "children": []
                  },
                  {
                    "value": 1165,
                    "label": "永年县",
                    "children": []
                  },
                  {
                    "value": 1166,
                    "label": "邱县",
                    "children": []
                  },
                  {
                    "value": 1167,
                    "label": "鸡泽县",
                    "children": []
                  },
                  {
                    "value": 1168,
                    "label": "广平县",
                    "children": []
                  },
                  {
                    "value": 1169,
                    "label": "馆陶县",
                    "children": []
                  },
                  {
                    "value": 1170,
                    "label": "魏县",
                    "children": []
                  },
                  {
                    "value": 1171,
                    "label": "曲周县",
                    "children": []
                  }
                ]
              },
              {
                "value": 142,
                "label": "衡水",
                "children": [{
                    "value": 1173,
                    "label": "冀州市",
                    "children": []
                  },
                  {
                    "value": 1174,
                    "label": "深州市",
                    "children": []
                  },
                  {
                    "value": 1175,
                    "label": "枣强县",
                    "children": []
                  },
                  {
                    "value": 1176,
                    "label": "武邑县",
                    "children": []
                  },
                  {
                    "value": 1177,
                    "label": "武强县",
                    "children": []
                  },
                  {
                    "value": 1178,
                    "label": "饶阳县",
                    "children": []
                  },
                  {
                    "value": 1179,
                    "label": "安平县",
                    "children": []
                  },
                  {
                    "value": 1180,
                    "label": "故城县",
                    "children": []
                  },
                  {
                    "value": 1181,
                    "label": "景县",
                    "children": []
                  },
                  {
                    "value": 1182,
                    "label": "阜城县",
                    "children": []
                  }
                ]
              },
              {
                "value": 143,
                "label": "廊坊",
                "children": [{
                    "value": 1185,
                    "label": "霸州市",
                    "children": []
                  },
                  {
                    "value": 1186,
                    "label": "三河市",
                    "children": []
                  },
                  {
                    "value": 1187,
                    "label": "固安县",
                    "children": []
                  },
                  {
                    "value": 1188,
                    "label": "永清县",
                    "children": []
                  },
                  {
                    "value": 1189,
                    "label": "香河县",
                    "children": []
                  },
                  {
                    "value": 1190,
                    "label": "大城县",
                    "children": []
                  },
                  {
                    "value": 1191,
                    "label": "文安县",
                    "children": []
                  },
                  {
                    "value": 1192,
                    "label": "大厂县",
                    "children": []
                  }
                ]
              },
              {
                "value": 144,
                "label": "秦皇岛",
                "children": [{
                    "value": 1195,
                    "label": "北戴河区",
                    "children": []
                  },
                  {
                    "value": 1196,
                    "label": "昌黎县",
                    "children": []
                  },
                  {
                    "value": 1197,
                    "label": "抚宁县",
                    "children": []
                  },
                  {
                    "value": 1198,
                    "label": "卢龙县",
                    "children": []
                  },
                  {
                    "value": 1199,
                    "label": "青龙县",
                    "children": []
                  }
                ]
              },
              {
                "value": 145,
                "label": "唐山",
                "children": [{
                    "value": 1204,
                    "label": "丰南区",
                    "children": []
                  },
                  {
                    "value": 1205,
                    "label": "丰润区",
                    "children": []
                  },
                  {
                    "value": 1206,
                    "label": "遵化市",
                    "children": []
                  },
                  {
                    "value": 1207,
                    "label": "迁安市",
                    "children": []
                  },
                  {
                    "value": 1208,
                    "label": "滦县",
                    "children": []
                  },
                  {
                    "value": 1209,
                    "label": "滦南县",
                    "children": []
                  },
                  {
                    "value": 1210,
                    "label": "乐亭县",
                    "children": []
                  },
                  {
                    "value": 1211,
                    "label": "迁西县",
                    "children": []
                  },
                  {
                    "value": 1212,
                    "label": "玉田县",
                    "children": []
                  },
                  {
                    "value": 1213,
                    "label": "唐海县",
                    "children": []
                  }
                ]
              },
              {
                "value": 146,
                "label": "邢台",
                "children": [{
                    "value": 1216,
                    "label": "南宫市",
                    "children": []
                  },
                  {
                    "value": 1217,
                    "label": "沙河市",
                    "children": []
                  },
                  {
                    "value": 1218,
                    "label": "邢台县",
                    "children": []
                  },
                  {
                    "value": 1219,
                    "label": "临城县",
                    "children": []
                  },
                  {
                    "value": 1220,
                    "label": "内丘县",
                    "children": []
                  },
                  {
                    "value": 1221,
                    "label": "柏乡县",
                    "children": []
                  },
                  {
                    "value": 1222,
                    "label": "隆尧县",
                    "children": []
                  },
                  {
                    "value": 1223,
                    "label": "任县",
                    "children": []
                  },
                  {
                    "value": 1224,
                    "label": "南和县",
                    "children": []
                  },
                  {
                    "value": 1225,
                    "label": "宁晋县",
                    "children": []
                  },
                  {
                    "value": 1226,
                    "label": "巨鹿县",
                    "children": []
                  },
                  {
                    "value": 1227,
                    "label": "新河县",
                    "children": []
                  },
                  {
                    "value": 1228,
                    "label": "广宗县",
                    "children": []
                  },
                  {
                    "value": 1229,
                    "label": "平乡县",
                    "children": []
                  },
                  {
                    "value": 1230,
                    "label": "威县",
                    "children": []
                  },
                  {
                    "value": 1231,
                    "label": "清河县",
                    "children": []
                  },
                  {
                    "value": 1232,
                    "label": "临西县",
                    "children": []
                  }
                ]
              },
              {
                "value": 147,
                "label": "张家口",
                "children": [{
                    "value": 1235,
                    "label": "宣化区",
                    "children": []
                  },
                  {
                    "value": 1237,
                    "label": "宣化县",
                    "children": []
                  },
                  {
                    "value": 1238,
                    "label": "张北县",
                    "children": []
                  },
                  {
                    "value": 1239,
                    "label": "康保县",
                    "children": []
                  },
                  {
                    "value": 1240,
                    "label": "沽源县",
                    "children": []
                  },
                  {
                    "value": 1241,
                    "label": "尚义县",
                    "children": []
                  },
                  {
                    "value": 1242,
                    "label": "蔚县",
                    "children": []
                  },
                  {
                    "value": 1243,
                    "label": "阳原县",
                    "children": []
                  },
                  {
                    "value": 1244,
                    "label": "怀安县",
                    "children": []
                  },
                  {
                    "value": 1245,
                    "label": "万全县",
                    "children": []
                  },
                  {
                    "value": 1246,
                    "label": "怀来县",
                    "children": []
                  },
                  {
                    "value": 1247,
                    "label": "涿鹿县",
                    "children": []
                  },
                  {
                    "value": 1248,
                    "label": "赤城县",
                    "children": []
                  },
                  {
                    "value": 1249,
                    "label": "崇礼县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 10,
            "label": "河南",
            "children": [{
                "value": 148,
                "label": "郑州",
                "children": [{
                    "value": 1255,
                    "label": "上街区",
                    "children": []
                  },
                  {
                    "value": 1261,
                    "label": "巩义市",
                    "children": []
                  },
                  {
                    "value": 1262,
                    "label": "荥阳市",
                    "children": []
                  },
                  {
                    "value": 1263,
                    "label": "新密市",
                    "children": []
                  },
                  {
                    "value": 1264,
                    "label": "新郑市",
                    "children": []
                  },
                  {
                    "value": 1265,
                    "label": "登封市",
                    "children": []
                  },
                  {
                    "value": 1266,
                    "label": "中牟县",
                    "children": []
                  }
                ]
              },
              {
                "value": 149,
                "label": "洛阳",
                "children": [{
                    "value": 1272,
                    "label": "吉利区",
                    "children": []
                  },
                  {
                    "value": 1273,
                    "label": "偃师市",
                    "children": []
                  },
                  {
                    "value": 1274,
                    "label": "孟津县",
                    "children": []
                  },
                  {
                    "value": 1275,
                    "label": "新安县",
                    "children": []
                  },
                  {
                    "value": 1276,
                    "label": "栾川县",
                    "children": []
                  },
                  {
                    "value": 1277,
                    "label": "嵩县",
                    "children": []
                  },
                  {
                    "value": 1278,
                    "label": "汝阳县",
                    "children": []
                  },
                  {
                    "value": 1279,
                    "label": "宜阳县",
                    "children": []
                  },
                  {
                    "value": 1280,
                    "label": "洛宁县",
                    "children": []
                  },
                  {
                    "value": 1281,
                    "label": "伊川县",
                    "children": []
                  }
                ]
              },
              {
                "value": 150,
                "label": "开封",
                "children": [{
                    "value": 1287,
                    "label": "杞县",
                    "children": []
                  },
                  {
                    "value": 1288,
                    "label": "通许县",
                    "children": []
                  },
                  {
                    "value": 1289,
                    "label": "尉氏县",
                    "children": []
                  },
                  {
                    "value": 1290,
                    "label": "开封县",
                    "children": []
                  },
                  {
                    "value": 1291,
                    "label": "兰考县",
                    "children": []
                  }
                ]
              },
              {
                "value": 151,
                "label": "安阳",
                "children": [{
                    "value": 1296,
                    "label": "林州市",
                    "children": []
                  },
                  {
                    "value": 1297,
                    "label": "安阳县",
                    "children": []
                  },
                  {
                    "value": 1298,
                    "label": "汤阴县",
                    "children": []
                  },
                  {
                    "value": 1299,
                    "label": "滑县",
                    "children": []
                  },
                  {
                    "value": 1300,
                    "label": "内黄县",
                    "children": []
                  }
                ]
              },
              {
                "value": 152,
                "label": "鹤壁",
                "children": [{
                    "value": 1304,
                    "label": "浚县",
                    "children": []
                  },
                  {
                    "value": 1305,
                    "label": "淇县",
                    "children": []
                  }
                ]
              },
              {
                "value": 153,
                "label": "济源",
                "children": [{
                  "value": 1306,
                  "label": "济源市",
                  "children": []
                }]
              },
              {
                "value": 154,
                "label": "焦作",
                "children": [{
                    "value": 1311,
                    "label": "沁阳市",
                    "children": []
                  },
                  {
                    "value": 1312,
                    "label": "孟州市",
                    "children": []
                  },
                  {
                    "value": 1313,
                    "label": "修武县",
                    "children": []
                  },
                  {
                    "value": 1314,
                    "label": "博爱县",
                    "children": []
                  },
                  {
                    "value": 1315,
                    "label": "武陟县",
                    "children": []
                  },
                  {
                    "value": 1316,
                    "label": "温县",
                    "children": []
                  }
                ]
              },
              {
                "value": 155,
                "label": "南阳",
                "children": [{
                    "value": 1319,
                    "label": "邓州市",
                    "children": []
                  },
                  {
                    "value": 1320,
                    "label": "南召县",
                    "children": []
                  },
                  {
                    "value": 1321,
                    "label": "方城县",
                    "children": []
                  },
                  {
                    "value": 1322,
                    "label": "西峡县",
                    "children": []
                  },
                  {
                    "value": 1323,
                    "label": "镇平县",
                    "children": []
                  },
                  {
                    "value": 1324,
                    "label": "内乡县",
                    "children": []
                  },
                  {
                    "value": 1325,
                    "label": "淅川县",
                    "children": []
                  },
                  {
                    "value": 1326,
                    "label": "社旗县",
                    "children": []
                  },
                  {
                    "value": 1327,
                    "label": "唐河县",
                    "children": []
                  },
                  {
                    "value": 1328,
                    "label": "新野县",
                    "children": []
                  },
                  {
                    "value": 1329,
                    "label": "桐柏县",
                    "children": []
                  }
                ]
              },
              {
                "value": 156,
                "label": "平顶山",
                "children": [{
                    "value": 1333,
                    "label": "石龙区",
                    "children": []
                  },
                  {
                    "value": 1334,
                    "label": "舞钢市",
                    "children": []
                  },
                  {
                    "value": 1335,
                    "label": "汝州市",
                    "children": []
                  },
                  {
                    "value": 1336,
                    "label": "宝丰县",
                    "children": []
                  },
                  {
                    "value": 1337,
                    "label": "叶县",
                    "children": []
                  },
                  {
                    "value": 1338,
                    "label": "鲁山县",
                    "children": []
                  },
                  {
                    "value": 1339,
                    "label": "郏县",
                    "children": []
                  }
                ]
              },
              {
                "value": 157,
                "label": "三门峡",
                "children": [{
                    "value": 1341,
                    "label": "义马市",
                    "children": []
                  },
                  {
                    "value": 1342,
                    "label": "灵宝市",
                    "children": []
                  },
                  {
                    "value": 1343,
                    "label": "渑池县",
                    "children": []
                  },
                  {
                    "value": 1344,
                    "label": "陕县",
                    "children": []
                  },
                  {
                    "value": 1345,
                    "label": "卢氏县",
                    "children": []
                  }
                ]
              },
              {
                "value": 158,
                "label": "商丘",
                "children": [{
                    "value": 1347,
                    "label": "睢阳区",
                    "children": []
                  },
                  {
                    "value": 1348,
                    "label": "永城市",
                    "children": []
                  },
                  {
                    "value": 1349,
                    "label": "民权县",
                    "children": []
                  },
                  {
                    "value": 1350,
                    "label": "睢县",
                    "children": []
                  },
                  {
                    "value": 1351,
                    "label": "宁陵县",
                    "children": []
                  },
                  {
                    "value": 1352,
                    "label": "虞城县",
                    "children": []
                  },
                  {
                    "value": 1353,
                    "label": "柘城县",
                    "children": []
                  },
                  {
                    "value": 1354,
                    "label": "夏邑县",
                    "children": []
                  }
                ]
              },
              {
                "value": 159,
                "label": "新乡",
                "children": [{
                    "value": 1359,
                    "label": "卫辉市",
                    "children": []
                  },
                  {
                    "value": 1360,
                    "label": "辉县市",
                    "children": []
                  },
                  {
                    "value": 1361,
                    "label": "新乡县",
                    "children": []
                  },
                  {
                    "value": 1362,
                    "label": "获嘉县",
                    "children": []
                  },
                  {
                    "value": 1363,
                    "label": "原阳县",
                    "children": []
                  },
                  {
                    "value": 1364,
                    "label": "延津县",
                    "children": []
                  },
                  {
                    "value": 1365,
                    "label": "封丘县",
                    "children": []
                  },
                  {
                    "value": 1366,
                    "label": "长垣县",
                    "children": []
                  }
                ]
              },
              {
                "value": 160,
                "label": "信阳",
                "children": [{
                    "value": 1369,
                    "label": "罗山县",
                    "children": []
                  },
                  {
                    "value": 1370,
                    "label": "光山县",
                    "children": []
                  },
                  {
                    "value": 1371,
                    "label": "新县",
                    "children": []
                  },
                  {
                    "value": 1372,
                    "label": "商城县",
                    "children": []
                  },
                  {
                    "value": 1373,
                    "label": "固始县",
                    "children": []
                  },
                  {
                    "value": 1374,
                    "label": "潢川县",
                    "children": []
                  },
                  {
                    "value": 1375,
                    "label": "淮滨县",
                    "children": []
                  },
                  {
                    "value": 1376,
                    "label": "息县",
                    "children": []
                  }
                ]
              },
              {
                "value": 161,
                "label": "许昌",
                "children": [{
                    "value": 1378,
                    "label": "禹州市",
                    "children": []
                  },
                  {
                    "value": 1379,
                    "label": "长葛市",
                    "children": []
                  },
                  {
                    "value": 1380,
                    "label": "许昌县",
                    "children": []
                  },
                  {
                    "value": 1381,
                    "label": "鄢陵县",
                    "children": []
                  },
                  {
                    "value": 1382,
                    "label": "襄城县",
                    "children": []
                  }
                ]
              },
              {
                "value": 162,
                "label": "周口",
                "children": [{
                    "value": 1384,
                    "label": "项城市",
                    "children": []
                  },
                  {
                    "value": 1385,
                    "label": "扶沟县",
                    "children": []
                  },
                  {
                    "value": 1386,
                    "label": "西华县",
                    "children": []
                  },
                  {
                    "value": 1387,
                    "label": "商水县",
                    "children": []
                  },
                  {
                    "value": 1388,
                    "label": "沈丘县",
                    "children": []
                  },
                  {
                    "value": 1389,
                    "label": "郸城县",
                    "children": []
                  },
                  {
                    "value": 1390,
                    "label": "淮阳县",
                    "children": []
                  },
                  {
                    "value": 1391,
                    "label": "太康县",
                    "children": []
                  },
                  {
                    "value": 1392,
                    "label": "鹿邑县",
                    "children": []
                  }
                ]
              },
              {
                "value": 163,
                "label": "驻马店",
                "children": [{
                    "value": 1394,
                    "label": "西平县",
                    "children": []
                  },
                  {
                    "value": 1395,
                    "label": "上蔡县",
                    "children": []
                  },
                  {
                    "value": 1396,
                    "label": "平舆县",
                    "children": []
                  },
                  {
                    "value": 1397,
                    "label": "正阳县",
                    "children": []
                  },
                  {
                    "value": 1398,
                    "label": "确山县",
                    "children": []
                  },
                  {
                    "value": 1399,
                    "label": "泌阳县",
                    "children": []
                  },
                  {
                    "value": 1400,
                    "label": "汝南县",
                    "children": []
                  },
                  {
                    "value": 1401,
                    "label": "遂平县",
                    "children": []
                  },
                  {
                    "value": 1402,
                    "label": "新蔡县",
                    "children": []
                  }
                ]
              },
              {
                "value": 164,
                "label": "漯河",
                "children": [{
                    "value": 1406,
                    "label": "舞阳县",
                    "children": []
                  },
                  {
                    "value": 1407,
                    "label": "临颍县",
                    "children": []
                  }
                ]
              },
              {
                "value": 165,
                "label": "濮阳",
                "children": [{
                    "value": 1409,
                    "label": "清丰县",
                    "children": []
                  },
                  {
                    "value": 1410,
                    "label": "南乐县",
                    "children": []
                  },
                  {
                    "value": 1411,
                    "label": "范县",
                    "children": []
                  },
                  {
                    "value": 1412,
                    "label": "台前县",
                    "children": []
                  },
                  {
                    "value": 1413,
                    "label": "濮阳县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 11,
            "label": "黑龙江",
            "children": [{
                "value": 166,
                "label": "哈尔滨",
                "children": [{
                    "value": 1421,
                    "label": "阿城区",
                    "children": []
                  },
                  {
                    "value": 1422,
                    "label": "呼兰区",
                    "children": []
                  },
                  {
                    "value": 1424,
                    "label": "尚志市",
                    "children": []
                  },
                  {
                    "value": 1425,
                    "label": "双城市",
                    "children": []
                  },
                  {
                    "value": 1426,
                    "label": "五常市",
                    "children": []
                  },
                  {
                    "value": 1427,
                    "label": "方正县",
                    "children": []
                  },
                  {
                    "value": 1428,
                    "label": "宾县",
                    "children": []
                  },
                  {
                    "value": 1429,
                    "label": "依兰县",
                    "children": []
                  },
                  {
                    "value": 1430,
                    "label": "巴彦县",
                    "children": []
                  },
                  {
                    "value": 1431,
                    "label": "通河县",
                    "children": []
                  },
                  {
                    "value": 1432,
                    "label": "木兰县",
                    "children": []
                  },
                  {
                    "value": 1433,
                    "label": "延寿县",
                    "children": []
                  }
                ]
              },
              {
                "value": 167,
                "label": "大庆",
                "children": [{
                    "value": 1439,
                    "label": "肇州县",
                    "children": []
                  },
                  {
                    "value": 1440,
                    "label": "肇源县",
                    "children": []
                  },
                  {
                    "value": 1441,
                    "label": "林甸县",
                    "children": []
                  },
                  {
                    "value": 1442,
                    "label": "杜尔伯特",
                    "children": []
                  }
                ]
              },
              {
                "value": 168,
                "label": "大兴安岭",
                "children": [{
                    "value": 1443,
                    "label": "呼玛县",
                    "children": []
                  },
                  {
                    "value": 1444,
                    "label": "漠河县",
                    "children": []
                  },
                  {
                    "value": 1445,
                    "label": "塔河县",
                    "children": []
                  },
                  {
                    "value": 3259,
                    "label": "加格达奇区",
                    "children": []
                  },
                  {
                    "value": 3261,
                    "label": "新林区",
                    "children": []
                  },
                  {
                    "value": 3262,
                    "label": "呼中区",
                    "children": []
                  }
                ]
              },
              {
                "value": 169,
                "label": "鹤岗",
                "children": [{
                    "value": 1448,
                    "label": "南山区",
                    "children": []
                  },
                  {
                    "value": 1452,
                    "label": "萝北县",
                    "children": []
                  },
                  {
                    "value": 1453,
                    "label": "绥滨县",
                    "children": []
                  }
                ]
              },
              {
                "value": 170,
                "label": "黑河",
                "children": [{
                    "value": 1455,
                    "label": "五大连池市",
                    "children": []
                  },
                  {
                    "value": 1456,
                    "label": "北安市",
                    "children": []
                  },
                  {
                    "value": 1457,
                    "label": "嫩江县",
                    "children": []
                  },
                  {
                    "value": 1458,
                    "label": "逊克县",
                    "children": []
                  },
                  {
                    "value": 1459,
                    "label": "孙吴县",
                    "children": []
                  }
                ]
              },
              {
                "value": 171,
                "label": "鸡西",
                "children": [{
                    "value": 1465,
                    "label": "虎林市",
                    "children": []
                  },
                  {
                    "value": 1466,
                    "label": "密山市",
                    "children": []
                  },
                  {
                    "value": 1467,
                    "label": "鸡东县",
                    "children": []
                  }
                ]
              },
              {
                "value": 172,
                "label": "佳木斯",
                "children": [{
                    "value": 1472,
                    "label": "同江市",
                    "children": []
                  },
                  {
                    "value": 1473,
                    "label": "富锦市",
                    "children": []
                  },
                  {
                    "value": 1474,
                    "label": "桦南县",
                    "children": []
                  },
                  {
                    "value": 1475,
                    "label": "桦川县",
                    "children": []
                  },
                  {
                    "value": 1476,
                    "label": "汤原县",
                    "children": []
                  },
                  {
                    "value": 1477,
                    "label": "抚远县",
                    "children": []
                  }
                ]
              },
              {
                "value": 173,
                "label": "牡丹江",
                "children": [{
                    "value": 1482,
                    "label": "绥芬河市",
                    "children": []
                  },
                  {
                    "value": 1483,
                    "label": "海林市",
                    "children": []
                  },
                  {
                    "value": 1484,
                    "label": "宁安市",
                    "children": []
                  },
                  {
                    "value": 1485,
                    "label": "穆棱市",
                    "children": []
                  },
                  {
                    "value": 1486,
                    "label": "东宁县",
                    "children": []
                  },
                  {
                    "value": 1487,
                    "label": "林口县",
                    "children": []
                  }
                ]
              },
              {
                "value": 174,
                "label": "七台河",
                "children": [{
                  "value": 1491,
                  "label": "勃利县",
                  "children": []
                }]
              },
              {
                "value": 175,
                "label": "齐齐哈尔",
                "children": [{
                    "value": 1499,
                    "label": "讷河市",
                    "children": []
                  },
                  {
                    "value": 1500,
                    "label": "龙江县",
                    "children": []
                  },
                  {
                    "value": 1501,
                    "label": "依安县",
                    "children": []
                  },
                  {
                    "value": 1502,
                    "label": "泰来县",
                    "children": []
                  },
                  {
                    "value": 1503,
                    "label": "甘南县",
                    "children": []
                  },
                  {
                    "value": 1504,
                    "label": "富裕县",
                    "children": []
                  },
                  {
                    "value": 1505,
                    "label": "克山县",
                    "children": []
                  },
                  {
                    "value": 1506,
                    "label": "克东县",
                    "children": []
                  },
                  {
                    "value": 1507,
                    "label": "拜泉县",
                    "children": []
                  }
                ]
              },
              {
                "value": 176,
                "label": "双鸭山",
                "children": [{
                    "value": 1512,
                    "label": "集贤县",
                    "children": []
                  },
                  {
                    "value": 1513,
                    "label": "友谊县",
                    "children": []
                  },
                  {
                    "value": 1514,
                    "label": "宝清县",
                    "children": []
                  },
                  {
                    "value": 1515,
                    "label": "饶河县",
                    "children": []
                  }
                ]
              },
              {
                "value": 177,
                "label": "绥化",
                "children": [{
                    "value": 1517,
                    "label": "安达市",
                    "children": []
                  },
                  {
                    "value": 1518,
                    "label": "肇东市",
                    "children": []
                  },
                  {
                    "value": 1519,
                    "label": "海伦市",
                    "children": []
                  },
                  {
                    "value": 1520,
                    "label": "望奎县",
                    "children": []
                  },
                  {
                    "value": 1521,
                    "label": "兰西县",
                    "children": []
                  },
                  {
                    "value": 1522,
                    "label": "青冈县",
                    "children": []
                  },
                  {
                    "value": 1523,
                    "label": "庆安县",
                    "children": []
                  },
                  {
                    "value": 1524,
                    "label": "明水县",
                    "children": []
                  },
                  {
                    "value": 1525,
                    "label": "绥棱县",
                    "children": []
                  }
                ]
              },
              {
                "value": 178,
                "label": "伊春",
                "children": [{
                    "value": 1526,
                    "label": "伊春区",
                    "children": []
                  },
                  {
                    "value": 1536,
                    "label": "五营区",
                    "children": []
                  },
                  {
                    "value": 1540,
                    "label": "乌伊岭区",
                    "children": []
                  },
                  {
                    "value": 1541,
                    "label": "铁力市",
                    "children": []
                  },
                  {
                    "value": 1542,
                    "label": "嘉荫县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 12,
            "label": "湖北",
            "children": [{
                "value": 179,
                "label": "武汉",
                "children": [{
                    "value": 1550,
                    "label": "东西湖区",
                    "children": []
                  },
                  {
                    "value": 1552,
                    "label": "蔡甸区",
                    "children": []
                  },
                  {
                    "value": 1553,
                    "label": "江夏区",
                    "children": []
                  },
                  {
                    "value": 1554,
                    "label": "黄陂区",
                    "children": []
                  },
                  {
                    "value": 1555,
                    "label": "新洲区",
                    "children": []
                  }
                ]
              },
              {
                "value": 180,
                "label": "仙桃",
                "children": []
              },
              {
                "value": 181,
                "label": "鄂州",
                "children": [{
                  "value": 1560,
                  "label": "梁子湖区",
                  "children": []
                }]
              },
              {
                "value": 182,
                "label": "黄冈",
                "children": [{
                    "value": 1562,
                    "label": "麻城市",
                    "children": []
                  },
                  {
                    "value": 1563,
                    "label": "武穴市",
                    "children": []
                  },
                  {
                    "value": 1564,
                    "label": "团风县",
                    "children": []
                  },
                  {
                    "value": 1565,
                    "label": "红安县",
                    "children": []
                  },
                  {
                    "value": 1566,
                    "label": "罗田县",
                    "children": []
                  },
                  {
                    "value": 1567,
                    "label": "英山县",
                    "children": []
                  },
                  {
                    "value": 1568,
                    "label": "浠水县",
                    "children": []
                  },
                  {
                    "value": 1569,
                    "label": "蕲春县",
                    "children": []
                  },
                  {
                    "value": 1570,
                    "label": "黄梅县",
                    "children": []
                  }
                ]
              },
              {
                "value": 183,
                "label": "黄石",
                "children": [{
                    "value": 1572,
                    "label": "西塞山区",
                    "children": []
                  },
                  {
                    "value": 1573,
                    "label": "下陆区",
                    "children": []
                  },
                  {
                    "value": 1574,
                    "label": "铁山区",
                    "children": []
                  },
                  {
                    "value": 1575,
                    "label": "大冶市",
                    "children": []
                  },
                  {
                    "value": 1576,
                    "label": "阳新县",
                    "children": []
                  }
                ]
              },
              {
                "value": 184,
                "label": "荆门",
                "children": [{
                    "value": 1578,
                    "label": "掇刀区",
                    "children": []
                  },
                  {
                    "value": 1579,
                    "label": "钟祥市",
                    "children": []
                  },
                  {
                    "value": 1580,
                    "label": "京山县",
                    "children": []
                  },
                  {
                    "value": 1581,
                    "label": "沙洋县",
                    "children": []
                  }
                ]
              },
              {
                "value": 185,
                "label": "荆州",
                "children": [{
                    "value": 1583,
                    "label": "荆州区",
                    "children": []
                  },
                  {
                    "value": 1584,
                    "label": "石首市",
                    "children": []
                  },
                  {
                    "value": 1585,
                    "label": "洪湖市",
                    "children": []
                  },
                  {
                    "value": 1586,
                    "label": "松滋市",
                    "children": []
                  },
                  {
                    "value": 1587,
                    "label": "公安县",
                    "children": []
                  },
                  {
                    "value": 1588,
                    "label": "监利县",
                    "children": []
                  },
                  {
                    "value": 1589,
                    "label": "江陵县",
                    "children": []
                  }
                ]
              },
              {
                "value": 186,
                "label": "潜江",
                "children": [{
                  "value": 1590,
                  "label": "潜江市",
                  "children": []
                }]
              },
              {
                "value": 187,
                "label": "神农架林区",
                "children": []
              },
              {
                "value": 188,
                "label": "十堰",
                "children": [{
                    "value": 1592,
                    "label": "张湾区",
                    "children": []
                  },
                  {
                    "value": 1593,
                    "label": "茅箭区",
                    "children": []
                  },
                  {
                    "value": 1594,
                    "label": "丹江口市",
                    "children": []
                  },
                  {
                    "value": 1595,
                    "label": "郧县",
                    "children": []
                  },
                  {
                    "value": 1596,
                    "label": "郧西县",
                    "children": []
                  },
                  {
                    "value": 1597,
                    "label": "竹山县",
                    "children": []
                  },
                  {
                    "value": 1598,
                    "label": "竹溪县",
                    "children": []
                  },
                  {
                    "value": 1599,
                    "label": "房县",
                    "children": []
                  }
                ]
              },
              {
                "value": 189,
                "label": "随州",
                "children": [{
                  "value": 1601,
                  "label": "广水市",
                  "children": []
                }]
              },
              {
                "value": 190,
                "label": "天门",
                "children": [{
                  "value": 1602,
                  "label": "天门市",
                  "children": []
                }]
              },
              {
                "value": 191,
                "label": "咸宁",
                "children": [{
                    "value": 1604,
                    "label": "赤壁市",
                    "children": []
                  },
                  {
                    "value": 1605,
                    "label": "嘉鱼县",
                    "children": []
                  },
                  {
                    "value": 1606,
                    "label": "通城县",
                    "children": []
                  },
                  {
                    "value": 1607,
                    "label": "崇阳县",
                    "children": []
                  },
                  {
                    "value": 1608,
                    "label": "通山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 192,
                "label": "襄阳",
                "children": [{
                    "value": 1611,
                    "label": "襄州区",
                    "children": []
                  },
                  {
                    "value": 1612,
                    "label": "老河口市",
                    "children": []
                  },
                  {
                    "value": 1613,
                    "label": "枣阳市",
                    "children": []
                  },
                  {
                    "value": 1614,
                    "label": "宜城市",
                    "children": []
                  },
                  {
                    "value": 1615,
                    "label": "南漳县",
                    "children": []
                  },
                  {
                    "value": 1616,
                    "label": "谷城县",
                    "children": []
                  },
                  {
                    "value": 1617,
                    "label": "保康县",
                    "children": []
                  }
                ]
              },
              {
                "value": 193,
                "label": "孝感",
                "children": [{
                    "value": 1619,
                    "label": "应城市",
                    "children": []
                  },
                  {
                    "value": 1620,
                    "label": "安陆市",
                    "children": []
                  },
                  {
                    "value": 1621,
                    "label": "汉川市",
                    "children": []
                  },
                  {
                    "value": 1622,
                    "label": "孝昌县",
                    "children": []
                  },
                  {
                    "value": 1623,
                    "label": "大悟县",
                    "children": []
                  },
                  {
                    "value": 1624,
                    "label": "云梦县",
                    "children": []
                  }
                ]
              },
              {
                "value": 194,
                "label": "宜昌",
                "children": [{
                    "value": 1625,
                    "label": "长阳县",
                    "children": []
                  },
                  {
                    "value": 1626,
                    "label": "五峰县",
                    "children": []
                  },
                  {
                    "value": 1631,
                    "label": "夷陵区",
                    "children": []
                  },
                  {
                    "value": 1632,
                    "label": "宜都市",
                    "children": []
                  },
                  {
                    "value": 1633,
                    "label": "当阳市",
                    "children": []
                  },
                  {
                    "value": 1634,
                    "label": "枝江市",
                    "children": []
                  },
                  {
                    "value": 1635,
                    "label": "远安县",
                    "children": []
                  },
                  {
                    "value": 1636,
                    "label": "兴山县",
                    "children": []
                  },
                  {
                    "value": 1637,
                    "label": "秭归县",
                    "children": []
                  }
                ]
              },
              {
                "value": 195,
                "label": "恩施",
                "children": [{
                    "value": 1638,
                    "label": "恩施市",
                    "children": []
                  },
                  {
                    "value": 1639,
                    "label": "利川市",
                    "children": []
                  },
                  {
                    "value": 1640,
                    "label": "建始县",
                    "children": []
                  },
                  {
                    "value": 1641,
                    "label": "巴东县",
                    "children": []
                  },
                  {
                    "value": 1642,
                    "label": "宣恩县",
                    "children": []
                  },
                  {
                    "value": 1643,
                    "label": "咸丰县",
                    "children": []
                  },
                  {
                    "value": 1644,
                    "label": "来凤县",
                    "children": []
                  },
                  {
                    "value": 1645,
                    "label": "鹤峰县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 13,
            "label": "湖南",
            "children": [{
                "value": 196,
                "label": "长沙",
                "children": [{
                    "value": 1652,
                    "label": "浏阳市",
                    "children": []
                  },
                  {
                    "value": 1653,
                    "label": "长沙县",
                    "children": []
                  },
                  {
                    "value": 1654,
                    "label": "望城县",
                    "children": []
                  },
                  {
                    "value": 1655,
                    "label": "宁乡县",
                    "children": []
                  }
                ]
              },
              {
                "value": 197,
                "label": "张家界",
                "children": [{
                    "value": 1657,
                    "label": "武陵源区",
                    "children": []
                  },
                  {
                    "value": 1658,
                    "label": "慈利县",
                    "children": []
                  },
                  {
                    "value": 1659,
                    "label": "桑植县",
                    "children": []
                  }
                ]
              },
              {
                "value": 198,
                "label": "常德",
                "children": [{
                    "value": 1662,
                    "label": "津市市",
                    "children": []
                  },
                  {
                    "value": 1663,
                    "label": "安乡县",
                    "children": []
                  },
                  {
                    "value": 1664,
                    "label": "汉寿县",
                    "children": []
                  },
                  {
                    "value": 1665,
                    "label": "澧县",
                    "children": []
                  },
                  {
                    "value": 1666,
                    "label": "临澧县",
                    "children": []
                  },
                  {
                    "value": 1667,
                    "label": "桃源县",
                    "children": []
                  },
                  {
                    "value": 1668,
                    "label": "石门县",
                    "children": []
                  }
                ]
              },
              {
                "value": 199,
                "label": "郴州",
                "children": [{
                    "value": 1670,
                    "label": "苏仙区",
                    "children": []
                  },
                  {
                    "value": 1671,
                    "label": "资兴市",
                    "children": []
                  },
                  {
                    "value": 1672,
                    "label": "桂阳县",
                    "children": []
                  },
                  {
                    "value": 1673,
                    "label": "宜章县",
                    "children": []
                  },
                  {
                    "value": 1674,
                    "label": "永兴县",
                    "children": []
                  },
                  {
                    "value": 1675,
                    "label": "嘉禾县",
                    "children": []
                  },
                  {
                    "value": 1676,
                    "label": "临武县",
                    "children": []
                  },
                  {
                    "value": 1677,
                    "label": "汝城县",
                    "children": []
                  },
                  {
                    "value": 1678,
                    "label": "桂东县",
                    "children": []
                  },
                  {
                    "value": 1679,
                    "label": "安仁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 200,
                "label": "衡阳",
                "children": [{
                    "value": 1684,
                    "label": "南岳区",
                    "children": []
                  },
                  {
                    "value": 1685,
                    "label": "耒阳市",
                    "children": []
                  },
                  {
                    "value": 1686,
                    "label": "常宁市",
                    "children": []
                  },
                  {
                    "value": 1687,
                    "label": "衡阳县",
                    "children": []
                  },
                  {
                    "value": 1688,
                    "label": "衡南县",
                    "children": []
                  },
                  {
                    "value": 1689,
                    "label": "衡山县",
                    "children": []
                  },
                  {
                    "value": 1690,
                    "label": "衡东县",
                    "children": []
                  },
                  {
                    "value": 1691,
                    "label": "祁东县",
                    "children": []
                  }
                ]
              },
              {
                "value": 201,
                "label": "怀化",
                "children": [{
                    "value": 1692,
                    "label": "鹤城区",
                    "children": []
                  },
                  {
                    "value": 1693,
                    "label": "靖州县",
                    "children": []
                  },
                  {
                    "value": 1694,
                    "label": "麻阳县",
                    "children": []
                  },
                  {
                    "value": 1695,
                    "label": "通道县",
                    "children": []
                  },
                  {
                    "value": 1696,
                    "label": "新晃县",
                    "children": []
                  },
                  {
                    "value": 1697,
                    "label": "芷江县",
                    "children": []
                  },
                  {
                    "value": 1698,
                    "label": "沅陵县",
                    "children": []
                  },
                  {
                    "value": 1699,
                    "label": "辰溪县",
                    "children": []
                  },
                  {
                    "value": 1700,
                    "label": "溆浦县",
                    "children": []
                  },
                  {
                    "value": 1701,
                    "label": "中方县",
                    "children": []
                  },
                  {
                    "value": 1702,
                    "label": "会同县",
                    "children": []
                  },
                  {
                    "value": 1703,
                    "label": "洪江市",
                    "children": []
                  }
                ]
              },
              {
                "value": 202,
                "label": "娄底",
                "children": [{
                    "value": 1705,
                    "label": "冷水江市",
                    "children": []
                  },
                  {
                    "value": 1706,
                    "label": "涟源市",
                    "children": []
                  },
                  {
                    "value": 1707,
                    "label": "双峰县",
                    "children": []
                  },
                  {
                    "value": 1708,
                    "label": "新化县",
                    "children": []
                  }
                ]
              },
              {
                "value": 203,
                "label": "邵阳",
                "children": [{
                    "value": 1709,
                    "label": "城步县",
                    "children": []
                  },
                  {
                    "value": 1713,
                    "label": "武冈市",
                    "children": []
                  },
                  {
                    "value": 1714,
                    "label": "邵东县",
                    "children": []
                  },
                  {
                    "value": 1715,
                    "label": "新邵县",
                    "children": []
                  },
                  {
                    "value": 1716,
                    "label": "邵阳县",
                    "children": []
                  },
                  {
                    "value": 1717,
                    "label": "隆回县",
                    "children": []
                  },
                  {
                    "value": 1718,
                    "label": "洞口县",
                    "children": []
                  },
                  {
                    "value": 1719,
                    "label": "绥宁县",
                    "children": []
                  },
                  {
                    "value": 1720,
                    "label": "新宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 204,
                "label": "湘潭",
                "children": [{
                    "value": 1723,
                    "label": "湘乡市",
                    "children": []
                  },
                  {
                    "value": 1724,
                    "label": "韶山市",
                    "children": []
                  },
                  {
                    "value": 1725,
                    "label": "湘潭县",
                    "children": []
                  }
                ]
              },
              {
                "value": 205,
                "label": "湘西",
                "children": [{
                    "value": 1726,
                    "label": "吉首市",
                    "children": []
                  },
                  {
                    "value": 1727,
                    "label": "泸溪县",
                    "children": []
                  },
                  {
                    "value": 1728,
                    "label": "凤凰县",
                    "children": []
                  },
                  {
                    "value": 1729,
                    "label": "花垣县",
                    "children": []
                  },
                  {
                    "value": 1730,
                    "label": "保靖县",
                    "children": []
                  },
                  {
                    "value": 1731,
                    "label": "古丈县",
                    "children": []
                  },
                  {
                    "value": 1732,
                    "label": "永顺县",
                    "children": []
                  },
                  {
                    "value": 1733,
                    "label": "龙山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 206,
                "label": "益阳",
                "children": [{
                    "value": 1734,
                    "label": "赫山区",
                    "children": []
                  },
                  {
                    "value": 1736,
                    "label": "沅江市",
                    "children": []
                  },
                  {
                    "value": 1737,
                    "label": "南县",
                    "children": []
                  },
                  {
                    "value": 1738,
                    "label": "桃江县",
                    "children": []
                  },
                  {
                    "value": 1739,
                    "label": "安化县",
                    "children": []
                  }
                ]
              },
              {
                "value": 207,
                "label": "永州",
                "children": [{
                    "value": 1740,
                    "label": "江华县",
                    "children": []
                  },
                  {
                    "value": 1743,
                    "label": "祁阳县",
                    "children": []
                  },
                  {
                    "value": 1744,
                    "label": "东安县",
                    "children": []
                  },
                  {
                    "value": 1745,
                    "label": "双牌县",
                    "children": []
                  },
                  {
                    "value": 1746,
                    "label": "道县",
                    "children": []
                  },
                  {
                    "value": 1747,
                    "label": "江永县",
                    "children": []
                  },
                  {
                    "value": 1748,
                    "label": "宁远县",
                    "children": []
                  },
                  {
                    "value": 1749,
                    "label": "蓝山县",
                    "children": []
                  },
                  {
                    "value": 1750,
                    "label": "新田县",
                    "children": []
                  }
                ]
              },
              {
                "value": 208,
                "label": "岳阳",
                "children": [{
                    "value": 1754,
                    "label": "汨罗市",
                    "children": []
                  },
                  {
                    "value": 1755,
                    "label": "临湘市",
                    "children": []
                  },
                  {
                    "value": 1756,
                    "label": "岳阳县",
                    "children": []
                  },
                  {
                    "value": 1757,
                    "label": "华容县",
                    "children": []
                  },
                  {
                    "value": 1758,
                    "label": "湘阴县",
                    "children": []
                  },
                  {
                    "value": 1759,
                    "label": "平江县",
                    "children": []
                  }
                ]
              },
              {
                "value": 209,
                "label": "株洲",
                "children": [{
                    "value": 1764,
                    "label": "醴陵市",
                    "children": []
                  },
                  {
                    "value": 1765,
                    "label": "株洲县",
                    "children": []
                  },
                  {
                    "value": 1766,
                    "label": "攸县",
                    "children": []
                  },
                  {
                    "value": 1767,
                    "label": "茶陵县",
                    "children": []
                  },
                  {
                    "value": 1768,
                    "label": "炎陵县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 14,
            "label": "吉林",
            "children": [{
                "value": 210,
                "label": "长春",
                "children": [{
                    "value": 1774,
                    "label": "双阳区",
                    "children": []
                  },
                  {
                    "value": 1779,
                    "label": "德惠市",
                    "children": []
                  },
                  {
                    "value": 1780,
                    "label": "九台市",
                    "children": []
                  },
                  {
                    "value": 1781,
                    "label": "榆树市",
                    "children": []
                  },
                  {
                    "value": 1782,
                    "label": "农安县",
                    "children": []
                  }
                ]
              },
              {
                "value": 211,
                "label": "吉林市",
                "children": [{
                    "value": 1787,
                    "label": "蛟河市",
                    "children": []
                  },
                  {
                    "value": 1788,
                    "label": "桦甸市",
                    "children": []
                  },
                  {
                    "value": 1789,
                    "label": "舒兰市",
                    "children": []
                  },
                  {
                    "value": 1790,
                    "label": "磐石市",
                    "children": []
                  },
                  {
                    "value": 1791,
                    "label": "永吉县",
                    "children": []
                  }
                ]
              },
              {
                "value": 212,
                "label": "白城",
                "children": [{
                    "value": 1793,
                    "label": "洮南市",
                    "children": []
                  },
                  {
                    "value": 1794,
                    "label": "大安市",
                    "children": []
                  },
                  {
                    "value": 1795,
                    "label": "镇赉县",
                    "children": []
                  },
                  {
                    "value": 1796,
                    "label": "通榆县",
                    "children": []
                  }
                ]
              },
              {
                "value": 213,
                "label": "白山",
                "children": [{
                    "value": 1797,
                    "label": "江源区",
                    "children": []
                  },
                  {
                    "value": 1799,
                    "label": "长白县",
                    "children": []
                  },
                  {
                    "value": 1800,
                    "label": "临江市",
                    "children": []
                  },
                  {
                    "value": 1801,
                    "label": "抚松县",
                    "children": []
                  },
                  {
                    "value": 1802,
                    "label": "靖宇县",
                    "children": []
                  }
                ]
              },
              {
                "value": 214,
                "label": "辽源",
                "children": [{
                    "value": 1805,
                    "label": "东丰县",
                    "children": []
                  },
                  {
                    "value": 1806,
                    "label": "东辽县",
                    "children": []
                  }
                ]
              },
              {
                "value": 215,
                "label": "四平",
                "children": [{
                    "value": 1809,
                    "label": "伊通县",
                    "children": []
                  },
                  {
                    "value": 1810,
                    "label": "公主岭市",
                    "children": []
                  },
                  {
                    "value": 1811,
                    "label": "双辽市",
                    "children": []
                  },
                  {
                    "value": 1812,
                    "label": "梨树县",
                    "children": []
                  }
                ]
              },
              {
                "value": 216,
                "label": "松原",
                "children": [{
                    "value": 1813,
                    "label": "前郭尔罗斯",
                    "children": []
                  },
                  {
                    "value": 1815,
                    "label": "长岭县",
                    "children": []
                  },
                  {
                    "value": 1816,
                    "label": "乾安县",
                    "children": []
                  },
                  {
                    "value": 1817,
                    "label": "扶余市",
                    "children": []
                  }
                ]
              },
              {
                "value": 217,
                "label": "通化",
                "children": [{
                    "value": 1820,
                    "label": "梅河口市",
                    "children": []
                  },
                  {
                    "value": 1821,
                    "label": "集安市",
                    "children": []
                  },
                  {
                    "value": 1822,
                    "label": "通化县",
                    "children": []
                  },
                  {
                    "value": 1823,
                    "label": "辉南县",
                    "children": []
                  },
                  {
                    "value": 1824,
                    "label": "柳河县",
                    "children": []
                  }
                ]
              },
              {
                "value": 218,
                "label": "延边",
                "children": [{
                    "value": 1825,
                    "label": "延吉市",
                    "children": []
                  },
                  {
                    "value": 1826,
                    "label": "图们市",
                    "children": []
                  },
                  {
                    "value": 1827,
                    "label": "敦化市",
                    "children": []
                  },
                  {
                    "value": 1828,
                    "label": "珲春市",
                    "children": []
                  },
                  {
                    "value": 1829,
                    "label": "龙井市",
                    "children": []
                  },
                  {
                    "value": 1830,
                    "label": "和龙市",
                    "children": []
                  },
                  {
                    "value": 1831,
                    "label": "安图县",
                    "children": []
                  },
                  {
                    "value": 1832,
                    "label": "汪清县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 15,
            "label": "江苏",
            "children": [{
                "value": 219,
                "label": "南京",
                "children": [{
                    "value": 1841,
                    "label": "浦口区",
                    "children": []
                  },
                  {
                    "value": 1842,
                    "label": "江宁区",
                    "children": []
                  },
                  {
                    "value": 1843,
                    "label": "六合区",
                    "children": []
                  },
                  {
                    "value": 1844,
                    "label": "溧水区",
                    "children": []
                  },
                  {
                    "value": 1845,
                    "label": "高淳县",
                    "children": []
                  }
                ]
              },
              {
                "value": 220,
                "label": "苏州",
                "children": [{
                    "value": 1850,
                    "label": "吴中区",
                    "children": []
                  },
                  {
                    "value": 1853,
                    "label": "昆山市",
                    "children": []
                  },
                  {
                    "value": 1854,
                    "label": "常熟市",
                    "children": []
                  },
                  {
                    "value": 1855,
                    "label": "张家港市",
                    "children": []
                  },
                  {
                    "value": 1867,
                    "label": "吴江区",
                    "children": []
                  },
                  {
                    "value": 1868,
                    "label": "太仓市",
                    "children": []
                  }
                ]
              },
              {
                "value": 221,
                "label": "无锡",
                "children": [{
                    "value": 1872,
                    "label": "锡山区",
                    "children": []
                  },
                  {
                    "value": 1876,
                    "label": "江阴市",
                    "children": []
                  },
                  {
                    "value": 1877,
                    "label": "宜兴市",
                    "children": []
                  }
                ]
              },
              {
                "value": 222,
                "label": "常州",
                "children": [{
                    "value": 1883,
                    "label": "武进区",
                    "children": []
                  },
                  {
                    "value": 1884,
                    "label": "溧阳市",
                    "children": []
                  },
                  {
                    "value": 1885,
                    "label": "金坛区",
                    "children": []
                  }
                ]
              },
              {
                "value": 223,
                "label": "淮安",
                "children": [{
                    "value": 1888,
                    "label": "楚州区",
                    "children": []
                  },
                  {
                    "value": 1889,
                    "label": "淮阴区",
                    "children": []
                  },
                  {
                    "value": 1890,
                    "label": "涟水县",
                    "children": []
                  },
                  {
                    "value": 1891,
                    "label": "洪泽县",
                    "children": []
                  },
                  {
                    "value": 1892,
                    "label": "盱眙县",
                    "children": []
                  },
                  {
                    "value": 1893,
                    "label": "金湖县",
                    "children": []
                  }
                ]
              },
              {
                "value": 224,
                "label": "连云港",
                "children": [{
                    "value": 1897,
                    "label": "赣榆县",
                    "children": []
                  },
                  {
                    "value": 1898,
                    "label": "东海县",
                    "children": []
                  },
                  {
                    "value": 1899,
                    "label": "灌云县",
                    "children": []
                  },
                  {
                    "value": 1900,
                    "label": "灌南县",
                    "children": []
                  }
                ]
              },
              {
                "value": 225,
                "label": "南通",
                "children": [{
                    "value": 1904,
                    "label": "启东市",
                    "children": []
                  },
                  {
                    "value": 1905,
                    "label": "如皋市",
                    "children": []
                  },
                  {
                    "value": 1906,
                    "label": "通州区",
                    "children": []
                  },
                  {
                    "value": 1907,
                    "label": "海门市",
                    "children": []
                  },
                  {
                    "value": 1908,
                    "label": "海安县",
                    "children": []
                  },
                  {
                    "value": 1909,
                    "label": "如东县",
                    "children": []
                  }
                ]
              },
              {
                "value": 226,
                "label": "宿迁",
                "children": [{
                    "value": 1911,
                    "label": "宿豫区",
                    "children": []
                  },
                  {
                    "value": 1912,
                    "label": "宿豫县",
                    "children": []
                  },
                  {
                    "value": 1913,
                    "label": "沭阳县",
                    "children": []
                  },
                  {
                    "value": 1914,
                    "label": "泗阳县",
                    "children": []
                  },
                  {
                    "value": 1915,
                    "label": "泗洪县",
                    "children": []
                  }
                ]
              },
              {
                "value": 227,
                "label": "泰州",
                "children": [{
                    "value": 1918,
                    "label": "兴化市",
                    "children": []
                  },
                  {
                    "value": 1919,
                    "label": "靖江市",
                    "children": []
                  },
                  {
                    "value": 1920,
                    "label": "泰兴市",
                    "children": []
                  },
                  {
                    "value": 1921,
                    "label": "姜堰区",
                    "children": []
                  }
                ]
              },
              {
                "value": 228,
                "label": "徐州",
                "children": [{
                    "value": 1927,
                    "label": "新沂市",
                    "children": []
                  },
                  {
                    "value": 1928,
                    "label": "邳州市",
                    "children": []
                  },
                  {
                    "value": 1929,
                    "label": "丰县",
                    "children": []
                  },
                  {
                    "value": 1930,
                    "label": "沛县",
                    "children": []
                  },
                  {
                    "value": 1931,
                    "label": "铜山区",
                    "children": []
                  },
                  {
                    "value": 1932,
                    "label": "睢宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 229,
                "label": "盐城",
                "children": [{
                    "value": 1935,
                    "label": "盐都区",
                    "children": []
                  },
                  {
                    "value": 1937,
                    "label": "东台市",
                    "children": []
                  },
                  {
                    "value": 1938,
                    "label": "大丰区",
                    "children": []
                  },
                  {
                    "value": 1939,
                    "label": "响水县",
                    "children": []
                  },
                  {
                    "value": 1940,
                    "label": "滨海县",
                    "children": []
                  },
                  {
                    "value": 1941,
                    "label": "阜宁县",
                    "children": []
                  },
                  {
                    "value": 1942,
                    "label": "射阳县",
                    "children": []
                  },
                  {
                    "value": 1943,
                    "label": "建湖县",
                    "children": []
                  }
                ]
              },
              {
                "value": 230,
                "label": "扬州",
                "children": [{
                    "value": 1946,
                    "label": "邗江区",
                    "children": []
                  },
                  {
                    "value": 1947,
                    "label": "仪征市",
                    "children": []
                  },
                  {
                    "value": 1948,
                    "label": "高邮市",
                    "children": []
                  },
                  {
                    "value": 1949,
                    "label": "江都市",
                    "children": []
                  },
                  {
                    "value": 1950,
                    "label": "宝应县",
                    "children": []
                  }
                ]
              },
              {
                "value": 231,
                "label": "镇江",
                "children": [{
                    "value": 1953,
                    "label": "丹徒区",
                    "children": []
                  },
                  {
                    "value": 1954,
                    "label": "丹阳市",
                    "children": []
                  },
                  {
                    "value": 1955,
                    "label": "扬中市",
                    "children": []
                  },
                  {
                    "value": 1956,
                    "label": "句容市",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 16,
            "label": "江西",
            "children": [{
                "value": 232,
                "label": "南昌",
                "children": [{
                    "value": 1965,
                    "label": "南昌县",
                    "children": []
                  },
                  {
                    "value": 1966,
                    "label": "新建县",
                    "children": []
                  },
                  {
                    "value": 1967,
                    "label": "安义县",
                    "children": []
                  },
                  {
                    "value": 1968,
                    "label": "进贤县",
                    "children": []
                  }
                ]
              },
              {
                "value": 233,
                "label": "抚州",
                "children": [{
                    "value": 1970,
                    "label": "南城县",
                    "children": []
                  },
                  {
                    "value": 1971,
                    "label": "黎川县",
                    "children": []
                  },
                  {
                    "value": 1972,
                    "label": "南丰县",
                    "children": []
                  },
                  {
                    "value": 1973,
                    "label": "崇仁县",
                    "children": []
                  },
                  {
                    "value": 1974,
                    "label": "乐安县",
                    "children": []
                  },
                  {
                    "value": 1975,
                    "label": "宜黄县",
                    "children": []
                  },
                  {
                    "value": 1976,
                    "label": "金溪县",
                    "children": []
                  },
                  {
                    "value": 1977,
                    "label": "资溪县",
                    "children": []
                  },
                  {
                    "value": 1978,
                    "label": "东乡县",
                    "children": []
                  },
                  {
                    "value": 1979,
                    "label": "广昌县",
                    "children": []
                  }
                ]
              },
              {
                "value": 234,
                "label": "赣州",
                "children": [{
                    "value": 1981,
                    "label": "于都县",
                    "children": []
                  },
                  {
                    "value": 1982,
                    "label": "瑞金市",
                    "children": []
                  },
                  {
                    "value": 1983,
                    "label": "南康市",
                    "children": []
                  },
                  {
                    "value": 1984,
                    "label": "赣县",
                    "children": []
                  },
                  {
                    "value": 1985,
                    "label": "信丰县",
                    "children": []
                  },
                  {
                    "value": 1986,
                    "label": "大余县",
                    "children": []
                  },
                  {
                    "value": 1987,
                    "label": "上犹县",
                    "children": []
                  },
                  {
                    "value": 1988,
                    "label": "崇义县",
                    "children": []
                  },
                  {
                    "value": 1989,
                    "label": "安远县",
                    "children": []
                  },
                  {
                    "value": 1990,
                    "label": "龙南县",
                    "children": []
                  },
                  {
                    "value": 1991,
                    "label": "定南县",
                    "children": []
                  },
                  {
                    "value": 1992,
                    "label": "全南县",
                    "children": []
                  },
                  {
                    "value": 1993,
                    "label": "宁都县",
                    "children": []
                  },
                  {
                    "value": 1994,
                    "label": "兴国县",
                    "children": []
                  },
                  {
                    "value": 1995,
                    "label": "会昌县",
                    "children": []
                  },
                  {
                    "value": 1996,
                    "label": "寻乌县",
                    "children": []
                  },
                  {
                    "value": 1997,
                    "label": "石城县",
                    "children": []
                  }
                ]
              },
              {
                "value": 235,
                "label": "吉安",
                "children": [{
                    "value": 1998,
                    "label": "安福县",
                    "children": []
                  },
                  {
                    "value": 2001,
                    "label": "井冈山市",
                    "children": []
                  },
                  {
                    "value": 2002,
                    "label": "吉安县",
                    "children": []
                  },
                  {
                    "value": 2003,
                    "label": "吉水县",
                    "children": []
                  },
                  {
                    "value": 2004,
                    "label": "峡江县",
                    "children": []
                  },
                  {
                    "value": 2005,
                    "label": "新干县",
                    "children": []
                  },
                  {
                    "value": 2006,
                    "label": "永丰县",
                    "children": []
                  },
                  {
                    "value": 2007,
                    "label": "泰和县",
                    "children": []
                  },
                  {
                    "value": 2008,
                    "label": "遂川县",
                    "children": []
                  },
                  {
                    "value": 2009,
                    "label": "万安县",
                    "children": []
                  },
                  {
                    "value": 2010,
                    "label": "永新县",
                    "children": []
                  }
                ]
              },
              {
                "value": 236,
                "label": "景德镇",
                "children": [{
                    "value": 2013,
                    "label": "乐平市",
                    "children": []
                  },
                  {
                    "value": 2014,
                    "label": "浮梁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 237,
                "label": "九江",
                "children": [{
                    "value": 2016,
                    "label": "庐山区",
                    "children": []
                  },
                  {
                    "value": 2017,
                    "label": "瑞昌市",
                    "children": []
                  },
                  {
                    "value": 2018,
                    "label": "九江县",
                    "children": []
                  },
                  {
                    "value": 2019,
                    "label": "武宁县",
                    "children": []
                  },
                  {
                    "value": 2020,
                    "label": "修水县",
                    "children": []
                  },
                  {
                    "value": 2021,
                    "label": "永修县",
                    "children": []
                  },
                  {
                    "value": 2022,
                    "label": "德安县",
                    "children": []
                  },
                  {
                    "value": 2023,
                    "label": "星子县",
                    "children": []
                  },
                  {
                    "value": 2024,
                    "label": "都昌县",
                    "children": []
                  },
                  {
                    "value": 2025,
                    "label": "湖口县",
                    "children": []
                  },
                  {
                    "value": 2026,
                    "label": "彭泽县",
                    "children": []
                  }
                ]
              },
              {
                "value": 238,
                "label": "萍乡",
                "children": [{
                    "value": 2027,
                    "label": "安源区",
                    "children": []
                  },
                  {
                    "value": 2028,
                    "label": "湘东区",
                    "children": []
                  },
                  {
                    "value": 2029,
                    "label": "莲花县",
                    "children": []
                  },
                  {
                    "value": 2030,
                    "label": "芦溪县",
                    "children": []
                  },
                  {
                    "value": 2031,
                    "label": "上栗县",
                    "children": []
                  }
                ]
              },
              {
                "value": 239,
                "label": "上饶",
                "children": [{
                    "value": 2033,
                    "label": "德兴市",
                    "children": []
                  },
                  {
                    "value": 2034,
                    "label": "上饶县",
                    "children": []
                  },
                  {
                    "value": 2035,
                    "label": "广丰县",
                    "children": []
                  },
                  {
                    "value": 2036,
                    "label": "玉山县",
                    "children": []
                  },
                  {
                    "value": 2037,
                    "label": "铅山县",
                    "children": []
                  },
                  {
                    "value": 2038,
                    "label": "横峰县",
                    "children": []
                  },
                  {
                    "value": 2039,
                    "label": "弋阳县",
                    "children": []
                  },
                  {
                    "value": 2040,
                    "label": "余干县",
                    "children": []
                  },
                  {
                    "value": 2041,
                    "label": "鄱阳县",
                    "children": []
                  },
                  {
                    "value": 2042,
                    "label": "万年县",
                    "children": []
                  },
                  {
                    "value": 2043,
                    "label": "婺源县",
                    "children": []
                  }
                ]
              },
              {
                "value": 240,
                "label": "新余",
                "children": [{
                  "value": 2045,
                  "label": "分宜县",
                  "children": []
                }]
              },
              {
                "value": 241,
                "label": "宜春",
                "children": [{
                    "value": 2047,
                    "label": "丰城市",
                    "children": []
                  },
                  {
                    "value": 2048,
                    "label": "樟树市",
                    "children": []
                  },
                  {
                    "value": 2049,
                    "label": "高安市",
                    "children": []
                  },
                  {
                    "value": 2050,
                    "label": "奉新县",
                    "children": []
                  },
                  {
                    "value": 2051,
                    "label": "万载县",
                    "children": []
                  },
                  {
                    "value": 2052,
                    "label": "上高县",
                    "children": []
                  },
                  {
                    "value": 2053,
                    "label": "宜丰县",
                    "children": []
                  },
                  {
                    "value": 2054,
                    "label": "靖安县",
                    "children": []
                  },
                  {
                    "value": 2055,
                    "label": "铜鼓县",
                    "children": []
                  }
                ]
              },
              {
                "value": 242,
                "label": "鹰潭",
                "children": [{
                    "value": 2057,
                    "label": "贵溪市",
                    "children": []
                  },
                  {
                    "value": 2058,
                    "label": "余江县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 17,
            "label": "辽宁",
            "children": [{
                "value": 243,
                "label": "沈阳",
                "children": [{
                    "value": 2064,
                    "label": "苏家屯区",
                    "children": []
                  },
                  {
                    "value": 2067,
                    "label": "于洪区",
                    "children": []
                  },
                  {
                    "value": 2069,
                    "label": "新民市",
                    "children": []
                  },
                  {
                    "value": 2070,
                    "label": "辽中县",
                    "children": []
                  },
                  {
                    "value": 2071,
                    "label": "康平县",
                    "children": []
                  },
                  {
                    "value": 2072,
                    "label": "法库县",
                    "children": []
                  }
                ]
              },
              {
                "value": 244,
                "label": "大连",
                "children": [{
                    "value": 2077,
                    "label": "旅顺口区",
                    "children": []
                  },
                  {
                    "value": 2078,
                    "label": "金州区",
                    "children": []
                  },
                  {
                    "value": 2080,
                    "label": "瓦房店市",
                    "children": []
                  },
                  {
                    "value": 2081,
                    "label": "普兰店市",
                    "children": []
                  },
                  {
                    "value": 2082,
                    "label": "庄河市",
                    "children": []
                  },
                  {
                    "value": 2083,
                    "label": "长海县",
                    "children": []
                  }
                ]
              },
              {
                "value": 245,
                "label": "鞍山",
                "children": [{
                    "value": 2088,
                    "label": "岫岩县",
                    "children": []
                  },
                  {
                    "value": 2089,
                    "label": "海城市",
                    "children": []
                  },
                  {
                    "value": 2090,
                    "label": "台安县",
                    "children": []
                  }
                ]
              },
              {
                "value": 246,
                "label": "本溪",
                "children": [{
                    "value": 2091,
                    "label": "本溪县",
                    "children": []
                  },
                  {
                    "value": 2096,
                    "label": "桓仁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 247,
                "label": "朝阳",
                "children": [{
                    "value": 2099,
                    "label": "喀喇沁左翼蒙古族自治县",
                    "children": []
                  },
                  {
                    "value": 2100,
                    "label": "北票市",
                    "children": []
                  },
                  {
                    "value": 2101,
                    "label": "凌源市",
                    "children": []
                  },
                  {
                    "value": 2103,
                    "label": "建平县",
                    "children": []
                  }
                ]
              },
              {
                "value": 248,
                "label": "丹东",
                "children": [{
                    "value": 2107,
                    "label": "宽甸县",
                    "children": []
                  },
                  {
                    "value": 2108,
                    "label": "东港市",
                    "children": []
                  },
                  {
                    "value": 2109,
                    "label": "凤城市",
                    "children": []
                  }
                ]
              },
              {
                "value": 249,
                "label": "抚顺",
                "children": [{
                    "value": 2114,
                    "label": "清原县",
                    "children": []
                  },
                  {
                    "value": 2115,
                    "label": "新宾县",
                    "children": []
                  },
                  {
                    "value": 2116,
                    "label": "抚顺县",
                    "children": []
                  }
                ]
              },
              {
                "value": 250,
                "label": "阜新",
                "children": [{
                  "value": 2123,
                  "label": "彰武县",
                  "children": []
                }]
              },
              {
                "value": 251,
                "label": "葫芦岛",
                "children": [{
                    "value": 2127,
                    "label": "兴城市",
                    "children": []
                  },
                  {
                    "value": 2128,
                    "label": "绥中县",
                    "children": []
                  },
                  {
                    "value": 2129,
                    "label": "建昌县",
                    "children": []
                  }
                ]
              },
              {
                "value": 252,
                "label": "锦州",
                "children": [{
                    "value": 2133,
                    "label": "凌海市",
                    "children": []
                  },
                  {
                    "value": 2134,
                    "label": "北镇市",
                    "children": []
                  },
                  {
                    "value": 2135,
                    "label": "黑山县",
                    "children": []
                  },
                  {
                    "value": 2136,
                    "label": "义县",
                    "children": []
                  }
                ]
              },
              {
                "value": 253,
                "label": "辽阳",
                "children": [{
                    "value": 2141,
                    "label": "弓长岭区",
                    "children": []
                  },
                  {
                    "value": 2142,
                    "label": "灯塔市",
                    "children": []
                  },
                  {
                    "value": 2143,
                    "label": "辽阳县",
                    "children": []
                  }
                ]
              },
              {
                "value": 254,
                "label": "盘锦",
                "children": [{
                    "value": 2146,
                    "label": "大洼县",
                    "children": []
                  },
                  {
                    "value": 2147,
                    "label": "盘山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 255,
                "label": "铁岭",
                "children": [{
                    "value": 2150,
                    "label": "调兵山市",
                    "children": []
                  },
                  {
                    "value": 2151,
                    "label": "开原市",
                    "children": []
                  },
                  {
                    "value": 2152,
                    "label": "铁岭县",
                    "children": []
                  },
                  {
                    "value": 2153,
                    "label": "西丰县",
                    "children": []
                  },
                  {
                    "value": 2154,
                    "label": "昌图县",
                    "children": []
                  }
                ]
              },
              {
                "value": 256,
                "label": "营口",
                "children": [{
                    "value": 2159,
                    "label": "盖州市",
                    "children": []
                  },
                  {
                    "value": 2160,
                    "label": "大石桥市",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 18,
            "label": "内蒙古",
            "children": [{
                "value": 257,
                "label": "呼和浩特",
                "children": [{
                    "value": 2165,
                    "label": "清水河县",
                    "children": []
                  },
                  {
                    "value": 2166,
                    "label": "土默特左旗",
                    "children": []
                  },
                  {
                    "value": 2167,
                    "label": "托克托县",
                    "children": []
                  },
                  {
                    "value": 2168,
                    "label": "和林格尔县",
                    "children": []
                  },
                  {
                    "value": 2169,
                    "label": "武川县",
                    "children": []
                  }
                ]
              },
              {
                "value": 258,
                "label": "阿拉善盟",
                "children": [{
                    "value": 2170,
                    "label": "阿拉善左旗",
                    "children": []
                  },
                  {
                    "value": 2171,
                    "label": "阿拉善右旗",
                    "children": []
                  },
                  {
                    "value": 2172,
                    "label": "额济纳旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 259,
                "label": "巴彦淖尔",
                "children": [{
                    "value": 2173,
                    "label": "临河区",
                    "children": []
                  },
                  {
                    "value": 2174,
                    "label": "五原县",
                    "children": []
                  },
                  {
                    "value": 2175,
                    "label": "磴口县",
                    "children": []
                  },
                  {
                    "value": 2176,
                    "label": "乌拉特前旗",
                    "children": []
                  },
                  {
                    "value": 2177,
                    "label": "乌拉特中旗",
                    "children": []
                  },
                  {
                    "value": 2178,
                    "label": "乌拉特后旗",
                    "children": []
                  },
                  {
                    "value": 2179,
                    "label": "杭锦后旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 260,
                "label": "包头",
                "children": [{
                    "value": 2184,
                    "label": "石拐区",
                    "children": []
                  },
                  {
                    "value": 2185,
                    "label": "白云鄂博",
                    "children": []
                  },
                  {
                    "value": 2186,
                    "label": "土默特右旗",
                    "children": []
                  },
                  {
                    "value": 2187,
                    "label": "固阳县",
                    "children": []
                  },
                  {
                    "value": 2188,
                    "label": "达尔罕茂明安联合旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 261,
                "label": "赤峰",
                "children": [{
                    "value": 2192,
                    "label": "阿鲁科尔沁旗",
                    "children": []
                  },
                  {
                    "value": 2193,
                    "label": "巴林左旗",
                    "children": []
                  },
                  {
                    "value": 2194,
                    "label": "巴林右旗",
                    "children": []
                  },
                  {
                    "value": 2195,
                    "label": "林西县",
                    "children": []
                  },
                  {
                    "value": 2196,
                    "label": "克什克腾旗",
                    "children": []
                  },
                  {
                    "value": 2197,
                    "label": "翁牛特旗",
                    "children": []
                  },
                  {
                    "value": 2198,
                    "label": "喀喇沁旗",
                    "children": []
                  },
                  {
                    "value": 2199,
                    "label": "宁城县",
                    "children": []
                  },
                  {
                    "value": 2200,
                    "label": "敖汉旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 262,
                "label": "鄂尔多斯",
                "children": [{
                    "value": 2201,
                    "label": "东胜区",
                    "children": []
                  },
                  {
                    "value": 2202,
                    "label": "达拉特旗",
                    "children": []
                  },
                  {
                    "value": 2203,
                    "label": "准格尔旗",
                    "children": []
                  },
                  {
                    "value": 2204,
                    "label": "鄂托克前旗",
                    "children": []
                  },
                  {
                    "value": 2205,
                    "label": "鄂托克旗",
                    "children": []
                  },
                  {
                    "value": 2206,
                    "label": "杭锦旗",
                    "children": []
                  },
                  {
                    "value": 2207,
                    "label": "乌审旗",
                    "children": []
                  },
                  {
                    "value": 2208,
                    "label": "伊金霍洛旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 263,
                "label": "呼伦贝尔",
                "children": [{
                    "value": 2209,
                    "label": "海拉尔区",
                    "children": []
                  },
                  {
                    "value": 2210,
                    "label": "莫力达瓦",
                    "children": []
                  },
                  {
                    "value": 2211,
                    "label": "满洲里市",
                    "children": []
                  },
                  {
                    "value": 2212,
                    "label": "牙克石市",
                    "children": []
                  },
                  {
                    "value": 2213,
                    "label": "扎兰屯市",
                    "children": []
                  },
                  {
                    "value": 2214,
                    "label": "额尔古纳市",
                    "children": []
                  },
                  {
                    "value": 2215,
                    "label": "根河市",
                    "children": []
                  },
                  {
                    "value": 2216,
                    "label": "阿荣旗",
                    "children": []
                  },
                  {
                    "value": 2217,
                    "label": "鄂伦春自治旗",
                    "children": []
                  },
                  {
                    "value": 2218,
                    "label": "鄂温克族自治旗",
                    "children": []
                  },
                  {
                    "value": 2219,
                    "label": "陈巴尔虎旗",
                    "children": []
                  },
                  {
                    "value": 2220,
                    "label": "新巴尔虎左旗",
                    "children": []
                  },
                  {
                    "value": 2221,
                    "label": "新巴尔虎右旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 264,
                "label": "通辽",
                "children": [{
                    "value": 2223,
                    "label": "霍林郭勒市",
                    "children": []
                  },
                  {
                    "value": 2224,
                    "label": "科尔沁左翼中旗",
                    "children": []
                  },
                  {
                    "value": 2225,
                    "label": "科尔沁左翼后旗",
                    "children": []
                  },
                  {
                    "value": 2226,
                    "label": "开鲁县",
                    "children": []
                  },
                  {
                    "value": 2227,
                    "label": "库伦旗",
                    "children": []
                  },
                  {
                    "value": 2228,
                    "label": "奈曼旗",
                    "children": []
                  },
                  {
                    "value": 2229,
                    "label": "扎鲁特旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 265,
                "label": "乌海",
                "children": []
              },
              {
                "value": 266,
                "label": "乌兰察布",
                "children": [{
                    "value": 2233,
                    "label": "化德县",
                    "children": []
                  },
                  {
                    "value": 2234,
                    "label": "集宁区",
                    "children": []
                  },
                  {
                    "value": 2235,
                    "label": "丰镇市",
                    "children": []
                  },
                  {
                    "value": 2236,
                    "label": "卓资县",
                    "children": []
                  },
                  {
                    "value": 2237,
                    "label": "商都县",
                    "children": []
                  },
                  {
                    "value": 2238,
                    "label": "兴和县",
                    "children": []
                  },
                  {
                    "value": 2239,
                    "label": "凉城县",
                    "children": []
                  },
                  {
                    "value": 2240,
                    "label": "察哈尔右翼前旗",
                    "children": []
                  },
                  {
                    "value": 2241,
                    "label": "察哈尔右翼中旗",
                    "children": []
                  },
                  {
                    "value": 2242,
                    "label": "察哈尔右翼后旗",
                    "children": []
                  },
                  {
                    "value": 2243,
                    "label": "四子王旗",
                    "children": []
                  }
                ]
              },
              {
                "value": 267,
                "label": "锡林郭勒",
                "children": [{
                    "value": 2244,
                    "label": "二连浩特市",
                    "children": []
                  },
                  {
                    "value": 2245,
                    "label": "锡林浩特市",
                    "children": []
                  },
                  {
                    "value": 2246,
                    "label": "阿巴嘎旗",
                    "children": []
                  },
                  {
                    "value": 2247,
                    "label": "苏尼特左旗",
                    "children": []
                  },
                  {
                    "value": 2248,
                    "label": "苏尼特右旗",
                    "children": []
                  },
                  {
                    "value": 2249,
                    "label": "东乌珠穆沁旗",
                    "children": []
                  },
                  {
                    "value": 2250,
                    "label": "西乌珠穆沁旗",
                    "children": []
                  },
                  {
                    "value": 2251,
                    "label": "太仆寺旗",
                    "children": []
                  },
                  {
                    "value": 2252,
                    "label": "镶黄旗",
                    "children": []
                  },
                  {
                    "value": 2253,
                    "label": "正镶白旗",
                    "children": []
                  },
                  {
                    "value": 2255,
                    "label": "多伦县",
                    "children": []
                  }
                ]
              },
              {
                "value": 268,
                "label": "兴安盟",
                "children": [{
                    "value": 2256,
                    "label": "乌兰浩特市",
                    "children": []
                  },
                  {
                    "value": 2257,
                    "label": "阿尔山市",
                    "children": []
                  },
                  {
                    "value": 2258,
                    "label": "科尔沁右翼前旗",
                    "children": []
                  },
                  {
                    "value": 2259,
                    "label": "科尔沁右翼中旗",
                    "children": []
                  },
                  {
                    "value": 2260,
                    "label": "扎赉特旗",
                    "children": []
                  },
                  {
                    "value": 2261,
                    "label": "突泉县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 19,
            "label": "宁夏",
            "children": [{
                "value": 269,
                "label": "银川",
                "children": [{
                    "value": 2265,
                    "label": "灵武市",
                    "children": []
                  },
                  {
                    "value": 2266,
                    "label": "永宁县",
                    "children": []
                  },
                  {
                    "value": 2267,
                    "label": "贺兰县",
                    "children": []
                  }
                ]
              },
              {
                "value": 270,
                "label": "固原",
                "children": [{
                    "value": 2270,
                    "label": "西吉县",
                    "children": []
                  },
                  {
                    "value": 2271,
                    "label": "隆德县",
                    "children": []
                  },
                  {
                    "value": 2272,
                    "label": "泾源县",
                    "children": []
                  },
                  {
                    "value": 2273,
                    "label": "彭阳县",
                    "children": []
                  }
                ]
              },
              {
                "value": 271,
                "label": "石嘴山",
                "children": [{
                    "value": 2274,
                    "label": "惠农区",
                    "children": []
                  },
                  {
                    "value": 2275,
                    "label": "大武口区",
                    "children": []
                  },
                  {
                    "value": 2276,
                    "label": "惠农区",
                    "children": []
                  },
                  {
                    "value": 2277,
                    "label": "陶乐县",
                    "children": []
                  },
                  {
                    "value": 2278,
                    "label": "平罗县",
                    "children": []
                  }
                ]
              },
              {
                "value": 272,
                "label": "吴忠",
                "children": [{
                    "value": 2281,
                    "label": "青铜峡市",
                    "children": []
                  },
                  {
                    "value": 2283,
                    "label": "盐池县",
                    "children": []
                  },
                  {
                    "value": 2284,
                    "label": "同心县",
                    "children": []
                  }
                ]
              },
              {
                "value": 273,
                "label": "中卫",
                "children": [{
                    "value": 2286,
                    "label": "海原县",
                    "children": []
                  },
                  {
                    "value": 2287,
                    "label": "中宁县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 20,
            "label": "青海",
            "children": [{
                "value": 274,
                "label": "西宁",
                "children": [{
                    "value": 2292,
                    "label": "湟中县",
                    "children": []
                  },
                  {
                    "value": 2293,
                    "label": "湟源县",
                    "children": []
                  },
                  {
                    "value": 2294,
                    "label": "大通县",
                    "children": []
                  }
                ]
              },
              {
                "value": 275,
                "label": "果洛",
                "children": [{
                    "value": 2295,
                    "label": "玛沁县",
                    "children": []
                  },
                  {
                    "value": 2296,
                    "label": "班玛县",
                    "children": []
                  },
                  {
                    "value": 2297,
                    "label": "甘德县",
                    "children": []
                  },
                  {
                    "value": 2298,
                    "label": "达日县",
                    "children": []
                  },
                  {
                    "value": 2299,
                    "label": "久治县",
                    "children": []
                  },
                  {
                    "value": 2300,
                    "label": "玛多县",
                    "children": []
                  }
                ]
              },
              {
                "value": 276,
                "label": "海北",
                "children": [{
                    "value": 2301,
                    "label": "海晏县",
                    "children": []
                  },
                  {
                    "value": 2302,
                    "label": "祁连县",
                    "children": []
                  },
                  {
                    "value": 2303,
                    "label": "刚察县",
                    "children": []
                  },
                  {
                    "value": 2304,
                    "label": "门源县",
                    "children": []
                  }
                ]
              },
              {
                "value": 277,
                "label": "海东",
                "children": [{
                    "value": 2305,
                    "label": "平安县",
                    "children": []
                  },
                  {
                    "value": 2306,
                    "label": "乐都县",
                    "children": []
                  },
                  {
                    "value": 2307,
                    "label": "民和县",
                    "children": []
                  },
                  {
                    "value": 2308,
                    "label": "互助县",
                    "children": []
                  },
                  {
                    "value": 2309,
                    "label": "化隆县",
                    "children": []
                  },
                  {
                    "value": 2310,
                    "label": "循化县",
                    "children": []
                  }
                ]
              },
              {
                "value": 278,
                "label": "海南州",
                "children": [{
                    "value": 2311,
                    "label": "共和县",
                    "children": []
                  },
                  {
                    "value": 2312,
                    "label": "同德县",
                    "children": []
                  },
                  {
                    "value": 2313,
                    "label": "贵德县",
                    "children": []
                  },
                  {
                    "value": 2314,
                    "label": "兴海县",
                    "children": []
                  },
                  {
                    "value": 2315,
                    "label": "贵南县",
                    "children": []
                  }
                ]
              },
              {
                "value": 279,
                "label": "海西",
                "children": [{
                    "value": 2316,
                    "label": "德令哈市",
                    "children": []
                  },
                  {
                    "value": 2317,
                    "label": "格尔木市",
                    "children": []
                  },
                  {
                    "value": 2318,
                    "label": "乌兰县",
                    "children": []
                  },
                  {
                    "value": 2319,
                    "label": "都兰县",
                    "children": []
                  },
                  {
                    "value": 2320,
                    "label": "天峻县",
                    "children": []
                  }
                ]
              },
              {
                "value": 280,
                "label": "黄南",
                "children": [{
                    "value": 2321,
                    "label": "同仁县",
                    "children": []
                  },
                  {
                    "value": 2322,
                    "label": "尖扎县",
                    "children": []
                  },
                  {
                    "value": 2323,
                    "label": "泽库县",
                    "children": []
                  },
                  {
                    "value": 2324,
                    "label": "河南蒙古族自治县",
                    "children": []
                  }
                ]
              },
              {
                "value": 281,
                "label": "玉树",
                "children": [{
                    "value": 2325,
                    "label": "玉树县",
                    "children": []
                  },
                  {
                    "value": 2326,
                    "label": "杂多县",
                    "children": []
                  },
                  {
                    "value": 2327,
                    "label": "称多县",
                    "children": []
                  },
                  {
                    "value": 2328,
                    "label": "治多县",
                    "children": []
                  },
                  {
                    "value": 2329,
                    "label": "囊谦县",
                    "children": []
                  },
                  {
                    "value": 2330,
                    "label": "曲麻莱县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 21,
            "label": "山东",
            "children": [{
                "value": 282,
                "label": "济南",
                "children": [{
                    "value": 2336,
                    "label": "长清区",
                    "children": []
                  },
                  {
                    "value": 2337,
                    "label": "章丘市",
                    "children": []
                  },
                  {
                    "value": 2338,
                    "label": "平阴县",
                    "children": []
                  },
                  {
                    "value": 2339,
                    "label": "济阳县",
                    "children": []
                  },
                  {
                    "value": 2340,
                    "label": "商河县",
                    "children": []
                  }
                ]
              },
              {
                "value": 283,
                "label": "青岛",
                "children": [{
                    "value": 2347,
                    "label": "崂山区",
                    "children": []
                  },
                  {
                    "value": 2348,
                    "label": "胶州市",
                    "children": []
                  },
                  {
                    "value": 2349,
                    "label": "即墨市",
                    "children": []
                  },
                  {
                    "value": 2350,
                    "label": "平度市",
                    "children": []
                  },
                  {
                    "value": 2351,
                    "label": "胶南市",
                    "children": []
                  },
                  {
                    "value": 2352,
                    "label": "莱西市",
                    "children": []
                  }
                ]
              },
              {
                "value": 284,
                "label": "滨州",
                "children": [{
                    "value": 2354,
                    "label": "惠民县",
                    "children": []
                  },
                  {
                    "value": 2355,
                    "label": "阳信县",
                    "children": []
                  },
                  {
                    "value": 2356,
                    "label": "无棣县",
                    "children": []
                  },
                  {
                    "value": 2357,
                    "label": "沾化县",
                    "children": []
                  },
                  {
                    "value": 2358,
                    "label": "博兴县",
                    "children": []
                  },
                  {
                    "value": 2359,
                    "label": "邹平县",
                    "children": []
                  }
                ]
              },
              {
                "value": 285,
                "label": "德州",
                "children": [{
                    "value": 2361,
                    "label": "陵县",
                    "children": []
                  },
                  {
                    "value": 2362,
                    "label": "乐陵市",
                    "children": []
                  },
                  {
                    "value": 2363,
                    "label": "禹城市",
                    "children": []
                  },
                  {
                    "value": 2364,
                    "label": "宁津县",
                    "children": []
                  },
                  {
                    "value": 2365,
                    "label": "庆云县",
                    "children": []
                  },
                  {
                    "value": 2366,
                    "label": "临邑县",
                    "children": []
                  },
                  {
                    "value": 2367,
                    "label": "齐河县",
                    "children": []
                  },
                  {
                    "value": 2368,
                    "label": "平原县",
                    "children": []
                  },
                  {
                    "value": 2369,
                    "label": "夏津县",
                    "children": []
                  },
                  {
                    "value": 2370,
                    "label": "武城县",
                    "children": []
                  }
                ]
              },
              {
                "value": 286,
                "label": "东营",
                "children": [{
                    "value": 2371,
                    "label": "东营区",
                    "children": []
                  },
                  {
                    "value": 2372,
                    "label": "河口区",
                    "children": []
                  },
                  {
                    "value": 2373,
                    "label": "垦利县",
                    "children": []
                  },
                  {
                    "value": 2374,
                    "label": "利津县",
                    "children": []
                  },
                  {
                    "value": 2375,
                    "label": "广饶县",
                    "children": []
                  }
                ]
              },
              {
                "value": 287,
                "label": "菏泽",
                "children": [{
                    "value": 2377,
                    "label": "曹县",
                    "children": []
                  },
                  {
                    "value": 2378,
                    "label": "单县",
                    "children": []
                  },
                  {
                    "value": 2379,
                    "label": "成武县",
                    "children": []
                  },
                  {
                    "value": 2380,
                    "label": "巨野县",
                    "children": []
                  },
                  {
                    "value": 2381,
                    "label": "郓城县",
                    "children": []
                  },
                  {
                    "value": 2382,
                    "label": "鄄城县",
                    "children": []
                  },
                  {
                    "value": 2383,
                    "label": "定陶县",
                    "children": []
                  },
                  {
                    "value": 2384,
                    "label": "东明县",
                    "children": []
                  }
                ]
              },
              {
                "value": 288,
                "label": "济宁",
                "children": [{
                    "value": 2387,
                    "label": "曲阜市",
                    "children": []
                  },
                  {
                    "value": 2388,
                    "label": "兖州市",
                    "children": []
                  },
                  {
                    "value": 2389,
                    "label": "邹城市",
                    "children": []
                  },
                  {
                    "value": 2390,
                    "label": "微山县",
                    "children": []
                  },
                  {
                    "value": 2391,
                    "label": "鱼台县",
                    "children": []
                  },
                  {
                    "value": 2392,
                    "label": "金乡县",
                    "children": []
                  },
                  {
                    "value": 2393,
                    "label": "嘉祥县",
                    "children": []
                  },
                  {
                    "value": 2394,
                    "label": "汶上县",
                    "children": []
                  },
                  {
                    "value": 2395,
                    "label": "泗水县",
                    "children": []
                  },
                  {
                    "value": 2396,
                    "label": "梁山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 289,
                "label": "莱芜",
                "children": []
              },
              {
                "value": 290,
                "label": "聊城",
                "children": [{
                    "value": 2400,
                    "label": "临清市",
                    "children": []
                  },
                  {
                    "value": 2401,
                    "label": "阳谷县",
                    "children": []
                  },
                  {
                    "value": 2402,
                    "label": "莘县",
                    "children": []
                  },
                  {
                    "value": 2403,
                    "label": "茌平县",
                    "children": []
                  },
                  {
                    "value": 2404,
                    "label": "东阿县",
                    "children": []
                  },
                  {
                    "value": 2405,
                    "label": "冠县",
                    "children": []
                  },
                  {
                    "value": 2406,
                    "label": "高唐县",
                    "children": []
                  }
                ]
              },
              {
                "value": 291,
                "label": "临沂",
                "children": [{
                    "value": 2410,
                    "label": "沂南县",
                    "children": []
                  },
                  {
                    "value": 2411,
                    "label": "郯城县",
                    "children": []
                  },
                  {
                    "value": 2412,
                    "label": "沂水县",
                    "children": []
                  },
                  {
                    "value": 2413,
                    "label": "兰陵县",
                    "children": []
                  },
                  {
                    "value": 2414,
                    "label": "费县",
                    "children": []
                  },
                  {
                    "value": 2415,
                    "label": "平邑县",
                    "children": []
                  },
                  {
                    "value": 2416,
                    "label": "莒南县",
                    "children": []
                  },
                  {
                    "value": 2417,
                    "label": "蒙阴县",
                    "children": []
                  },
                  {
                    "value": 2418,
                    "label": "临沭县",
                    "children": []
                  }
                ]
              },
              {
                "value": 292,
                "label": "日照",
                "children": [{
                    "value": 2421,
                    "label": "五莲县",
                    "children": []
                  },
                  {
                    "value": 2422,
                    "label": "莒县",
                    "children": []
                  }
                ]
              },
              {
                "value": 293,
                "label": "泰安",
                "children": [{
                    "value": 2423,
                    "label": "泰山区",
                    "children": []
                  },
                  {
                    "value": 2425,
                    "label": "新泰市",
                    "children": []
                  },
                  {
                    "value": 2426,
                    "label": "肥城市",
                    "children": []
                  },
                  {
                    "value": 2427,
                    "label": "宁阳县",
                    "children": []
                  },
                  {
                    "value": 2428,
                    "label": "东平县",
                    "children": []
                  }
                ]
              },
              {
                "value": 294,
                "label": "威海",
                "children": [{
                    "value": 2429,
                    "label": "荣成市",
                    "children": []
                  },
                  {
                    "value": 2430,
                    "label": "乳山市",
                    "children": []
                  },
                  {
                    "value": 2432,
                    "label": "文登市",
                    "children": []
                  }
                ]
              },
              {
                "value": 295,
                "label": "潍坊",
                "children": [{
                    "value": 2437,
                    "label": "青州市",
                    "children": []
                  },
                  {
                    "value": 2438,
                    "label": "诸城市",
                    "children": []
                  },
                  {
                    "value": 2439,
                    "label": "寿光市",
                    "children": []
                  },
                  {
                    "value": 2440,
                    "label": "安丘市",
                    "children": []
                  },
                  {
                    "value": 2441,
                    "label": "高密市",
                    "children": []
                  },
                  {
                    "value": 2442,
                    "label": "昌邑市",
                    "children": []
                  },
                  {
                    "value": 2443,
                    "label": "临朐县",
                    "children": []
                  },
                  {
                    "value": 2444,
                    "label": "昌乐县",
                    "children": []
                  }
                ]
              },
              {
                "value": 296,
                "label": "烟台",
                "children": [{
                    "value": 2446,
                    "label": "福山区",
                    "children": []
                  },
                  {
                    "value": 2447,
                    "label": "牟平区",
                    "children": []
                  },
                  {
                    "value": 2450,
                    "label": "龙口市",
                    "children": []
                  },
                  {
                    "value": 2451,
                    "label": "莱阳市",
                    "children": []
                  },
                  {
                    "value": 2452,
                    "label": "莱州市",
                    "children": []
                  },
                  {
                    "value": 2453,
                    "label": "蓬莱市",
                    "children": []
                  },
                  {
                    "value": 2454,
                    "label": "招远市",
                    "children": []
                  },
                  {
                    "value": 2455,
                    "label": "栖霞市",
                    "children": []
                  },
                  {
                    "value": 2456,
                    "label": "海阳市",
                    "children": []
                  },
                  {
                    "value": 2457,
                    "label": "长岛县",
                    "children": []
                  }
                ]
              },
              {
                "value": 297,
                "label": "枣庄",
                "children": [{
                    "value": 2460,
                    "label": "峄城区",
                    "children": []
                  },
                  {
                    "value": 2461,
                    "label": "台儿庄区",
                    "children": []
                  },
                  {
                    "value": 2462,
                    "label": "薛城区",
                    "children": []
                  },
                  {
                    "value": 2463,
                    "label": "滕州市",
                    "children": []
                  }
                ]
              },
              {
                "value": 298,
                "label": "淄博",
                "children": [{
                    "value": 2465,
                    "label": "临淄区",
                    "children": []
                  },
                  {
                    "value": 2466,
                    "label": "淄川区",
                    "children": []
                  },
                  {
                    "value": 2467,
                    "label": "博山区",
                    "children": []
                  },
                  {
                    "value": 2468,
                    "label": "周村区",
                    "children": []
                  },
                  {
                    "value": 2469,
                    "label": "桓台县",
                    "children": []
                  },
                  {
                    "value": 2470,
                    "label": "高青县",
                    "children": []
                  },
                  {
                    "value": 2471,
                    "label": "沂源县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 22,
            "label": "山西",
            "children": [{
                "value": 299,
                "label": "太原",
                "children": [{
                    "value": 2481,
                    "label": "清徐县",
                    "children": []
                  },
                  {
                    "value": 2482,
                    "label": "阳曲县",
                    "children": []
                  },
                  {
                    "value": 2483,
                    "label": "娄烦县",
                    "children": []
                  },
                  {
                    "value": 2484,
                    "label": "古交市",
                    "children": []
                  }
                ]
              },
              {
                "value": 300,
                "label": "长治",
                "children": [{
                    "value": 2487,
                    "label": "沁县",
                    "children": []
                  },
                  {
                    "value": 2488,
                    "label": "潞城市",
                    "children": []
                  },
                  {
                    "value": 2489,
                    "label": "长治县",
                    "children": []
                  },
                  {
                    "value": 2490,
                    "label": "襄垣县",
                    "children": []
                  },
                  {
                    "value": 2491,
                    "label": "屯留县",
                    "children": []
                  },
                  {
                    "value": 2492,
                    "label": "平顺县",
                    "children": []
                  },
                  {
                    "value": 2493,
                    "label": "黎城县",
                    "children": []
                  },
                  {
                    "value": 2494,
                    "label": "壶关县",
                    "children": []
                  },
                  {
                    "value": 2495,
                    "label": "长子县",
                    "children": []
                  },
                  {
                    "value": 2496,
                    "label": "武乡县",
                    "children": []
                  },
                  {
                    "value": 2497,
                    "label": "沁源县",
                    "children": []
                  }
                ]
              },
              {
                "value": 301,
                "label": "大同",
                "children": [{
                    "value": 2502,
                    "label": "阳高县",
                    "children": []
                  },
                  {
                    "value": 2503,
                    "label": "天镇县",
                    "children": []
                  },
                  {
                    "value": 2504,
                    "label": "广灵县",
                    "children": []
                  },
                  {
                    "value": 2505,
                    "label": "灵丘县",
                    "children": []
                  },
                  {
                    "value": 2506,
                    "label": "浑源县",
                    "children": []
                  },
                  {
                    "value": 2507,
                    "label": "左云县",
                    "children": []
                  },
                  {
                    "value": 2508,
                    "label": "大同县",
                    "children": []
                  }
                ]
              },
              {
                "value": 302,
                "label": "晋城",
                "children": [{
                    "value": 2510,
                    "label": "高平市",
                    "children": []
                  },
                  {
                    "value": 2511,
                    "label": "沁水县",
                    "children": []
                  },
                  {
                    "value": 2512,
                    "label": "阳城县",
                    "children": []
                  },
                  {
                    "value": 2513,
                    "label": "陵川县",
                    "children": []
                  },
                  {
                    "value": 2514,
                    "label": "泽州县",
                    "children": []
                  }
                ]
              },
              {
                "value": 303,
                "label": "晋中",
                "children": [{
                    "value": 2515,
                    "label": "榆次区",
                    "children": []
                  },
                  {
                    "value": 2516,
                    "label": "介休市",
                    "children": []
                  },
                  {
                    "value": 2517,
                    "label": "榆社县",
                    "children": []
                  },
                  {
                    "value": 2518,
                    "label": "左权县",
                    "children": []
                  },
                  {
                    "value": 2519,
                    "label": "和顺县",
                    "children": []
                  },
                  {
                    "value": 2520,
                    "label": "昔阳县",
                    "children": []
                  },
                  {
                    "value": 2521,
                    "label": "寿阳县",
                    "children": []
                  },
                  {
                    "value": 2522,
                    "label": "太谷县",
                    "children": []
                  },
                  {
                    "value": 2523,
                    "label": "祁县",
                    "children": []
                  },
                  {
                    "value": 2524,
                    "label": "平遥县",
                    "children": []
                  },
                  {
                    "value": 2525,
                    "label": "灵石县",
                    "children": []
                  }
                ]
              },
              {
                "value": 304,
                "label": "临汾",
                "children": [{
                    "value": 2527,
                    "label": "侯马市",
                    "children": []
                  },
                  {
                    "value": 2528,
                    "label": "霍州市",
                    "children": []
                  },
                  {
                    "value": 2529,
                    "label": "曲沃县",
                    "children": []
                  },
                  {
                    "value": 2530,
                    "label": "翼城县",
                    "children": []
                  },
                  {
                    "value": 2531,
                    "label": "襄汾县",
                    "children": []
                  },
                  {
                    "value": 2532,
                    "label": "洪洞县",
                    "children": []
                  },
                  {
                    "value": 2533,
                    "label": "吉县",
                    "children": []
                  },
                  {
                    "value": 2534,
                    "label": "安泽县",
                    "children": []
                  },
                  {
                    "value": 2535,
                    "label": "浮山县",
                    "children": []
                  },
                  {
                    "value": 2536,
                    "label": "古县",
                    "children": []
                  },
                  {
                    "value": 2537,
                    "label": "乡宁县",
                    "children": []
                  },
                  {
                    "value": 2538,
                    "label": "大宁县",
                    "children": []
                  },
                  {
                    "value": 2539,
                    "label": "隰县",
                    "children": []
                  },
                  {
                    "value": 2540,
                    "label": "永和县",
                    "children": []
                  },
                  {
                    "value": 2541,
                    "label": "蒲县",
                    "children": []
                  },
                  {
                    "value": 2542,
                    "label": "汾西县",
                    "children": []
                  }
                ]
              },
              {
                "value": 305,
                "label": "吕梁",
                "children": [{
                    "value": 2543,
                    "label": "离石市",
                    "children": []
                  },
                  {
                    "value": 2544,
                    "label": "离石区",
                    "children": []
                  },
                  {
                    "value": 2545,
                    "label": "孝义市",
                    "children": []
                  },
                  {
                    "value": 2546,
                    "label": "汾阳市",
                    "children": []
                  },
                  {
                    "value": 2547,
                    "label": "文水县",
                    "children": []
                  },
                  {
                    "value": 2548,
                    "label": "交城县",
                    "children": []
                  },
                  {
                    "value": 2549,
                    "label": "兴县",
                    "children": []
                  },
                  {
                    "value": 2550,
                    "label": "临县",
                    "children": []
                  },
                  {
                    "value": 2551,
                    "label": "柳林县",
                    "children": []
                  },
                  {
                    "value": 2552,
                    "label": "石楼县",
                    "children": []
                  },
                  {
                    "value": 2553,
                    "label": "岚县",
                    "children": []
                  },
                  {
                    "value": 2554,
                    "label": "方山县",
                    "children": []
                  },
                  {
                    "value": 2555,
                    "label": "中阳县",
                    "children": []
                  },
                  {
                    "value": 2556,
                    "label": "交口县",
                    "children": []
                  }
                ]
              },
              {
                "value": 306,
                "label": "朔州",
                "children": [{
                    "value": 2558,
                    "label": "平鲁区",
                    "children": []
                  },
                  {
                    "value": 2559,
                    "label": "山阴县",
                    "children": []
                  },
                  {
                    "value": 2560,
                    "label": "应县",
                    "children": []
                  },
                  {
                    "value": 2561,
                    "label": "右玉县",
                    "children": []
                  },
                  {
                    "value": 2562,
                    "label": "怀仁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 307,
                "label": "忻州",
                "children": [{
                    "value": 2564,
                    "label": "原平市",
                    "children": []
                  },
                  {
                    "value": 2565,
                    "label": "定襄县",
                    "children": []
                  },
                  {
                    "value": 2566,
                    "label": "五台县",
                    "children": []
                  },
                  {
                    "value": 2567,
                    "label": "代县",
                    "children": []
                  },
                  {
                    "value": 2568,
                    "label": "繁峙县",
                    "children": []
                  },
                  {
                    "value": 2569,
                    "label": "宁武县",
                    "children": []
                  },
                  {
                    "value": 2570,
                    "label": "静乐县",
                    "children": []
                  },
                  {
                    "value": 2571,
                    "label": "神池县",
                    "children": []
                  },
                  {
                    "value": 2572,
                    "label": "五寨县",
                    "children": []
                  },
                  {
                    "value": 2573,
                    "label": "岢岚县",
                    "children": []
                  },
                  {
                    "value": 2574,
                    "label": "河曲县",
                    "children": []
                  },
                  {
                    "value": 2575,
                    "label": "保德县",
                    "children": []
                  },
                  {
                    "value": 2576,
                    "label": "偏关县",
                    "children": []
                  }
                ]
              },
              {
                "value": 308,
                "label": "阳泉",
                "children": [{
                    "value": 2580,
                    "label": "平定县",
                    "children": []
                  },
                  {
                    "value": 2581,
                    "label": "盂县",
                    "children": []
                  }
                ]
              },
              {
                "value": 309,
                "label": "运城",
                "children": [{
                    "value": 2583,
                    "label": "永济市",
                    "children": []
                  },
                  {
                    "value": 2584,
                    "label": "河津市",
                    "children": []
                  },
                  {
                    "value": 2585,
                    "label": "临猗县",
                    "children": []
                  },
                  {
                    "value": 2586,
                    "label": "万荣县",
                    "children": []
                  },
                  {
                    "value": 2587,
                    "label": "闻喜县",
                    "children": []
                  },
                  {
                    "value": 2588,
                    "label": "稷山县",
                    "children": []
                  },
                  {
                    "value": 2589,
                    "label": "新绛县",
                    "children": []
                  },
                  {
                    "value": 2590,
                    "label": "绛县",
                    "children": []
                  },
                  {
                    "value": 2591,
                    "label": "垣曲县",
                    "children": []
                  },
                  {
                    "value": 2592,
                    "label": "夏县",
                    "children": []
                  },
                  {
                    "value": 2593,
                    "label": "平陆县",
                    "children": []
                  },
                  {
                    "value": 2594,
                    "label": "芮城县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 23,
            "label": "陕西",
            "children": [{
                "value": 310,
                "label": "西安",
                "children": [{
                    "value": 2602,
                    "label": "临潼区",
                    "children": []
                  },
                  {
                    "value": 2603,
                    "label": "长安区",
                    "children": []
                  },
                  {
                    "value": 2604,
                    "label": "蓝田县",
                    "children": []
                  },
                  {
                    "value": 2605,
                    "label": "周至县",
                    "children": []
                  },
                  {
                    "value": 2606,
                    "label": "户县",
                    "children": []
                  },
                  {
                    "value": 2607,
                    "label": "高陵县",
                    "children": []
                  }
                ]
              },
              {
                "value": 311,
                "label": "安康",
                "children": [{
                    "value": 2609,
                    "label": "汉阴县",
                    "children": []
                  },
                  {
                    "value": 2610,
                    "label": "石泉县",
                    "children": []
                  },
                  {
                    "value": 2611,
                    "label": "宁陕县",
                    "children": []
                  },
                  {
                    "value": 2612,
                    "label": "紫阳县",
                    "children": []
                  },
                  {
                    "value": 2613,
                    "label": "岚皋县",
                    "children": []
                  },
                  {
                    "value": 2614,
                    "label": "平利县",
                    "children": []
                  },
                  {
                    "value": 2615,
                    "label": "镇坪县",
                    "children": []
                  },
                  {
                    "value": 2616,
                    "label": "旬阳县",
                    "children": []
                  },
                  {
                    "value": 2617,
                    "label": "白河县",
                    "children": []
                  }
                ]
              },
              {
                "value": 312,
                "label": "宝鸡",
                "children": [{
                    "value": 2618,
                    "label": "陈仓区",
                    "children": []
                  },
                  {
                    "value": 2621,
                    "label": "凤翔县",
                    "children": []
                  },
                  {
                    "value": 2622,
                    "label": "岐山县",
                    "children": []
                  },
                  {
                    "value": 2623,
                    "label": "扶风县",
                    "children": []
                  },
                  {
                    "value": 2624,
                    "label": "眉县",
                    "children": []
                  },
                  {
                    "value": 2625,
                    "label": "陇县",
                    "children": []
                  },
                  {
                    "value": 2626,
                    "label": "千阳县",
                    "children": []
                  },
                  {
                    "value": 2627,
                    "label": "麟游县",
                    "children": []
                  },
                  {
                    "value": 2628,
                    "label": "凤县",
                    "children": []
                  },
                  {
                    "value": 2629,
                    "label": "太白县",
                    "children": []
                  }
                ]
              },
              {
                "value": 313,
                "label": "汉中",
                "children": [{
                    "value": 2631,
                    "label": "南郑县",
                    "children": []
                  },
                  {
                    "value": 2632,
                    "label": "城固县",
                    "children": []
                  },
                  {
                    "value": 2633,
                    "label": "洋县",
                    "children": []
                  },
                  {
                    "value": 2634,
                    "label": "西乡县",
                    "children": []
                  },
                  {
                    "value": 2635,
                    "label": "勉县",
                    "children": []
                  },
                  {
                    "value": 2636,
                    "label": "宁强县",
                    "children": []
                  },
                  {
                    "value": 2637,
                    "label": "略阳县",
                    "children": []
                  },
                  {
                    "value": 2638,
                    "label": "镇巴县",
                    "children": []
                  },
                  {
                    "value": 2639,
                    "label": "留坝县",
                    "children": []
                  },
                  {
                    "value": 2640,
                    "label": "佛坪县",
                    "children": []
                  }
                ]
              },
              {
                "value": 314,
                "label": "商洛",
                "children": [{
                    "value": 2641,
                    "label": "商州区",
                    "children": []
                  },
                  {
                    "value": 2642,
                    "label": "洛南县",
                    "children": []
                  },
                  {
                    "value": 2643,
                    "label": "丹凤县",
                    "children": []
                  },
                  {
                    "value": 2644,
                    "label": "商南县",
                    "children": []
                  },
                  {
                    "value": 2645,
                    "label": "山阳县",
                    "children": []
                  },
                  {
                    "value": 2646,
                    "label": "镇安县",
                    "children": []
                  },
                  {
                    "value": 2647,
                    "label": "柞水县",
                    "children": []
                  }
                ]
              },
              {
                "value": 315,
                "label": "铜川",
                "children": [{
                    "value": 2648,
                    "label": "耀州区",
                    "children": []
                  },
                  {
                    "value": 2651,
                    "label": "宜君县",
                    "children": []
                  }
                ]
              },
              {
                "value": 316,
                "label": "渭南",
                "children": [{
                    "value": 2653,
                    "label": "韩城市",
                    "children": []
                  },
                  {
                    "value": 2654,
                    "label": "华阴市",
                    "children": []
                  },
                  {
                    "value": 2655,
                    "label": "华县",
                    "children": []
                  },
                  {
                    "value": 2656,
                    "label": "潼关县",
                    "children": []
                  },
                  {
                    "value": 2657,
                    "label": "大荔县",
                    "children": []
                  },
                  {
                    "value": 2658,
                    "label": "合阳县",
                    "children": []
                  },
                  {
                    "value": 2659,
                    "label": "澄城县",
                    "children": []
                  },
                  {
                    "value": 2660,
                    "label": "蒲城县",
                    "children": []
                  },
                  {
                    "value": 2661,
                    "label": "白水县",
                    "children": []
                  },
                  {
                    "value": 2662,
                    "label": "富平县",
                    "children": []
                  }
                ]
              },
              {
                "value": 317,
                "label": "咸阳",
                "children": [{
                    "value": 2666,
                    "label": "兴平市",
                    "children": []
                  },
                  {
                    "value": 2667,
                    "label": "三原县",
                    "children": []
                  },
                  {
                    "value": 2668,
                    "label": "泾阳县",
                    "children": []
                  },
                  {
                    "value": 2669,
                    "label": "乾县",
                    "children": []
                  },
                  {
                    "value": 2670,
                    "label": "礼泉县",
                    "children": []
                  },
                  {
                    "value": 2671,
                    "label": "永寿县",
                    "children": []
                  },
                  {
                    "value": 2672,
                    "label": "彬县",
                    "children": []
                  },
                  {
                    "value": 2673,
                    "label": "长武县",
                    "children": []
                  },
                  {
                    "value": 2674,
                    "label": "旬邑县",
                    "children": []
                  },
                  {
                    "value": 2675,
                    "label": "淳化县",
                    "children": []
                  },
                  {
                    "value": 2676,
                    "label": "武功县",
                    "children": []
                  }
                ]
              },
              {
                "value": 318,
                "label": "延安",
                "children": [{
                    "value": 2677,
                    "label": "吴起县",
                    "children": []
                  },
                  {
                    "value": 2679,
                    "label": "延长县",
                    "children": []
                  },
                  {
                    "value": 2680,
                    "label": "延川县",
                    "children": []
                  },
                  {
                    "value": 2681,
                    "label": "子长县",
                    "children": []
                  },
                  {
                    "value": 2682,
                    "label": "安塞县",
                    "children": []
                  },
                  {
                    "value": 2683,
                    "label": "志丹县",
                    "children": []
                  },
                  {
                    "value": 2684,
                    "label": "甘泉县",
                    "children": []
                  },
                  {
                    "value": 2685,
                    "label": "富县",
                    "children": []
                  },
                  {
                    "value": 2686,
                    "label": "洛川县",
                    "children": []
                  },
                  {
                    "value": 2687,
                    "label": "宜川县",
                    "children": []
                  },
                  {
                    "value": 2688,
                    "label": "黄龙县",
                    "children": []
                  },
                  {
                    "value": 2689,
                    "label": "黄陵县",
                    "children": []
                  }
                ]
              },
              {
                "value": 319,
                "label": "榆林",
                "children": [{
                    "value": 2690,
                    "label": "榆阳区",
                    "children": []
                  },
                  {
                    "value": 2691,
                    "label": "神木县",
                    "children": []
                  },
                  {
                    "value": 2692,
                    "label": "府谷县",
                    "children": []
                  },
                  {
                    "value": 2693,
                    "label": "横山县",
                    "children": []
                  },
                  {
                    "value": 2694,
                    "label": "靖边县",
                    "children": []
                  },
                  {
                    "value": 2695,
                    "label": "定边县",
                    "children": []
                  },
                  {
                    "value": 2696,
                    "label": "绥德县",
                    "children": []
                  },
                  {
                    "value": 2697,
                    "label": "米脂县",
                    "children": []
                  },
                  {
                    "value": 2698,
                    "label": "佳县",
                    "children": []
                  },
                  {
                    "value": 2699,
                    "label": "吴堡县",
                    "children": []
                  },
                  {
                    "value": 2700,
                    "label": "清涧县",
                    "children": []
                  },
                  {
                    "value": 2701,
                    "label": "子洲县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 24,
            "label": "上海",
            "children": [{
                "value": 2704,
                "label": "闵行区",
                "children": []
              },
              {
                "value": 2706,
                "label": "浦东新区",
                "children": []
              },
              {
                "value": 2714,
                "label": "松江区",
                "children": []
              },
              {
                "value": 2715,
                "label": "嘉定区",
                "children": []
              },
              {
                "value": 2716,
                "label": "宝山区",
                "children": []
              },
              {
                "value": 2717,
                "label": "青浦区",
                "children": []
              },
              {
                "value": 2718,
                "label": "金山区",
                "children": []
              },
              {
                "value": 2719,
                "label": "奉贤区",
                "children": []
              },
              {
                "value": 2720,
                "label": "崇明区",
                "children": []
              }
            ]
          },
          {
            "value": 25,
            "label": "四川",
            "children": [{
                "value": 321,
                "label": "成都",
                "children": [{
                    "value": 2726,
                    "label": "龙泉驿区",
                    "children": []
                  },
                  {
                    "value": 2727,
                    "label": "青白江区",
                    "children": []
                  },
                  {
                    "value": 2728,
                    "label": "新都区",
                    "children": []
                  },
                  {
                    "value": 2729,
                    "label": "温江区",
                    "children": []
                  },
                  {
                    "value": 2732,
                    "label": "都江堰市",
                    "children": []
                  },
                  {
                    "value": 2733,
                    "label": "彭州市",
                    "children": []
                  },
                  {
                    "value": 2734,
                    "label": "邛崃市",
                    "children": []
                  },
                  {
                    "value": 2735,
                    "label": "崇州市",
                    "children": []
                  },
                  {
                    "value": 2736,
                    "label": "金堂县",
                    "children": []
                  },
                  {
                    "value": 2737,
                    "label": "双流县",
                    "children": []
                  },
                  {
                    "value": 2738,
                    "label": "郫县",
                    "children": []
                  },
                  {
                    "value": 2739,
                    "label": "大邑县",
                    "children": []
                  },
                  {
                    "value": 2740,
                    "label": "蒲江县",
                    "children": []
                  },
                  {
                    "value": 2741,
                    "label": "新津县",
                    "children": []
                  },
                  {
                    "value": 2895,
                    "label": "简阳市",
                    "children": []
                  }
                ]
              },
              {
                "value": 322,
                "label": "绵阳",
                "children": [{
                    "value": 2754,
                    "label": "江油市",
                    "children": []
                  },
                  {
                    "value": 2755,
                    "label": "盐亭县",
                    "children": []
                  },
                  {
                    "value": 2756,
                    "label": "三台县",
                    "children": []
                  },
                  {
                    "value": 2757,
                    "label": "平武县",
                    "children": []
                  },
                  {
                    "value": 2758,
                    "label": "安县",
                    "children": []
                  },
                  {
                    "value": 2759,
                    "label": "梓潼县",
                    "children": []
                  },
                  {
                    "value": 2760,
                    "label": "北川县",
                    "children": []
                  }
                ]
              },
              {
                "value": 323,
                "label": "阿坝",
                "children": [{
                    "value": 2761,
                    "label": "马尔康县",
                    "children": []
                  },
                  {
                    "value": 2762,
                    "label": "汶川县",
                    "children": []
                  },
                  {
                    "value": 2763,
                    "label": "理县",
                    "children": []
                  },
                  {
                    "value": 2764,
                    "label": "茂县",
                    "children": []
                  },
                  {
                    "value": 2765,
                    "label": "松潘县",
                    "children": []
                  },
                  {
                    "value": 2766,
                    "label": "九寨沟县",
                    "children": []
                  },
                  {
                    "value": 2767,
                    "label": "金川县",
                    "children": []
                  },
                  {
                    "value": 2768,
                    "label": "小金县",
                    "children": []
                  },
                  {
                    "value": 2769,
                    "label": "黑水县",
                    "children": []
                  },
                  {
                    "value": 2770,
                    "label": "壤塘县",
                    "children": []
                  },
                  {
                    "value": 2771,
                    "label": "阿坝县",
                    "children": []
                  },
                  {
                    "value": 2772,
                    "label": "若尔盖县",
                    "children": []
                  },
                  {
                    "value": 2773,
                    "label": "红原县",
                    "children": []
                  }
                ]
              },
              {
                "value": 324,
                "label": "巴中",
                "children": [{
                    "value": 2775,
                    "label": "通江县",
                    "children": []
                  },
                  {
                    "value": 2776,
                    "label": "南江县",
                    "children": []
                  },
                  {
                    "value": 2777,
                    "label": "平昌县",
                    "children": []
                  }
                ]
              },
              {
                "value": 325,
                "label": "达州",
                "children": [{
                    "value": 2779,
                    "label": "万源市",
                    "children": []
                  },
                  {
                    "value": 2780,
                    "label": "达川区",
                    "children": []
                  },
                  {
                    "value": 2781,
                    "label": "宣汉县",
                    "children": []
                  },
                  {
                    "value": 2782,
                    "label": "开江县",
                    "children": []
                  },
                  {
                    "value": 2783,
                    "label": "大竹县",
                    "children": []
                  },
                  {
                    "value": 2784,
                    "label": "渠县",
                    "children": []
                  }
                ]
              },
              {
                "value": 326,
                "label": "德阳",
                "children": [{
                    "value": 2786,
                    "label": "广汉市",
                    "children": []
                  },
                  {
                    "value": 2787,
                    "label": "什邡市",
                    "children": []
                  },
                  {
                    "value": 2788,
                    "label": "绵竹市",
                    "children": []
                  },
                  {
                    "value": 2789,
                    "label": "罗江县",
                    "children": []
                  },
                  {
                    "value": 2790,
                    "label": "中江县",
                    "children": []
                  }
                ]
              },
              {
                "value": 327,
                "label": "甘孜",
                "children": [{
                    "value": 2791,
                    "label": "康定县",
                    "children": []
                  },
                  {
                    "value": 2792,
                    "label": "丹巴县",
                    "children": []
                  },
                  {
                    "value": 2793,
                    "label": "泸定县",
                    "children": []
                  },
                  {
                    "value": 2794,
                    "label": "炉霍县",
                    "children": []
                  },
                  {
                    "value": 2795,
                    "label": "九龙县",
                    "children": []
                  },
                  {
                    "value": 2796,
                    "label": "甘孜县",
                    "children": []
                  },
                  {
                    "value": 2797,
                    "label": "雅江县",
                    "children": []
                  },
                  {
                    "value": 2798,
                    "label": "新龙县",
                    "children": []
                  },
                  {
                    "value": 2799,
                    "label": "道孚县",
                    "children": []
                  },
                  {
                    "value": 2800,
                    "label": "白玉县",
                    "children": []
                  },
                  {
                    "value": 2801,
                    "label": "理塘县",
                    "children": []
                  },
                  {
                    "value": 2802,
                    "label": "德格县",
                    "children": []
                  },
                  {
                    "value": 2803,
                    "label": "乡城县",
                    "children": []
                  },
                  {
                    "value": 2804,
                    "label": "石渠县",
                    "children": []
                  },
                  {
                    "value": 2805,
                    "label": "稻城县",
                    "children": []
                  },
                  {
                    "value": 2806,
                    "label": "色达县",
                    "children": []
                  },
                  {
                    "value": 2807,
                    "label": "巴塘县",
                    "children": []
                  },
                  {
                    "value": 2808,
                    "label": "得荣县",
                    "children": []
                  }
                ]
              },
              {
                "value": 328,
                "label": "广安",
                "children": [{
                    "value": 2809,
                    "label": "广安区",
                    "children": []
                  },
                  {
                    "value": 2810,
                    "label": "华蓥市",
                    "children": []
                  },
                  {
                    "value": 2811,
                    "label": "岳池县",
                    "children": []
                  },
                  {
                    "value": 2812,
                    "label": "武胜县",
                    "children": []
                  },
                  {
                    "value": 2813,
                    "label": "邻水县",
                    "children": []
                  }
                ]
              },
              {
                "value": 329,
                "label": "广元",
                "children": [{
                    "value": 2817,
                    "label": "旺苍县",
                    "children": []
                  },
                  {
                    "value": 2818,
                    "label": "青川县",
                    "children": []
                  },
                  {
                    "value": 2819,
                    "label": "剑阁县",
                    "children": []
                  },
                  {
                    "value": 2820,
                    "label": "苍溪县",
                    "children": []
                  }
                ]
              },
              {
                "value": 330,
                "label": "乐山",
                "children": [{
                    "value": 2821,
                    "label": "峨眉山市",
                    "children": []
                  },
                  {
                    "value": 2823,
                    "label": "犍为县",
                    "children": []
                  },
                  {
                    "value": 2824,
                    "label": "井研县",
                    "children": []
                  },
                  {
                    "value": 2825,
                    "label": "夹江县",
                    "children": []
                  },
                  {
                    "value": 2826,
                    "label": "沐川县",
                    "children": []
                  },
                  {
                    "value": 2827,
                    "label": "峨边县",
                    "children": []
                  },
                  {
                    "value": 2828,
                    "label": "马边县",
                    "children": []
                  }
                ]
              },
              {
                "value": 331,
                "label": "凉山",
                "children": [{
                    "value": 2829,
                    "label": "西昌市",
                    "children": []
                  },
                  {
                    "value": 2830,
                    "label": "盐源县",
                    "children": []
                  },
                  {
                    "value": 2831,
                    "label": "德昌县",
                    "children": []
                  },
                  {
                    "value": 2832,
                    "label": "会理县",
                    "children": []
                  },
                  {
                    "value": 2833,
                    "label": "会东县",
                    "children": []
                  },
                  {
                    "value": 2834,
                    "label": "宁南县",
                    "children": []
                  },
                  {
                    "value": 2835,
                    "label": "普格县",
                    "children": []
                  },
                  {
                    "value": 2836,
                    "label": "布拖县",
                    "children": []
                  },
                  {
                    "value": 2837,
                    "label": "金阳县",
                    "children": []
                  },
                  {
                    "value": 2838,
                    "label": "昭觉县",
                    "children": []
                  },
                  {
                    "value": 2839,
                    "label": "喜德县",
                    "children": []
                  },
                  {
                    "value": 2840,
                    "label": "冕宁县",
                    "children": []
                  },
                  {
                    "value": 2841,
                    "label": "越西县",
                    "children": []
                  },
                  {
                    "value": 2842,
                    "label": "甘洛县",
                    "children": []
                  },
                  {
                    "value": 2843,
                    "label": "美姑县",
                    "children": []
                  },
                  {
                    "value": 2844,
                    "label": "雷波县",
                    "children": []
                  },
                  {
                    "value": 2845,
                    "label": "木里县",
                    "children": []
                  }
                ]
              },
              {
                "value": 332,
                "label": "眉山",
                "children": [{
                    "value": 2847,
                    "label": "仁寿县",
                    "children": []
                  },
                  {
                    "value": 2848,
                    "label": "彭山县",
                    "children": []
                  },
                  {
                    "value": 2849,
                    "label": "洪雅县",
                    "children": []
                  },
                  {
                    "value": 2850,
                    "label": "丹棱县",
                    "children": []
                  },
                  {
                    "value": 2851,
                    "label": "青神县",
                    "children": []
                  }
                ]
              },
              {
                "value": 333,
                "label": "南充",
                "children": [{
                    "value": 2852,
                    "label": "阆中市",
                    "children": []
                  },
                  {
                    "value": 2853,
                    "label": "南部县",
                    "children": []
                  },
                  {
                    "value": 2854,
                    "label": "营山县",
                    "children": []
                  },
                  {
                    "value": 2855,
                    "label": "蓬安县",
                    "children": []
                  },
                  {
                    "value": 2856,
                    "label": "仪陇县",
                    "children": []
                  },
                  {
                    "value": 2860,
                    "label": "西充县",
                    "children": []
                  }
                ]
              },
              {
                "value": 334,
                "label": "内江",
                "children": [{
                    "value": 2862,
                    "label": "东兴区",
                    "children": []
                  },
                  {
                    "value": 2863,
                    "label": "威远县",
                    "children": []
                  },
                  {
                    "value": 2864,
                    "label": "资中县",
                    "children": []
                  },
                  {
                    "value": 2865,
                    "label": "隆昌县",
                    "children": []
                  }
                ]
              },
              {
                "value": 335,
                "label": "攀枝花",
                "children": [{
                    "value": 2868,
                    "label": "仁和区",
                    "children": []
                  },
                  {
                    "value": 2869,
                    "label": "米易县",
                    "children": []
                  },
                  {
                    "value": 2870,
                    "label": "盐边县",
                    "children": []
                  }
                ]
              },
              {
                "value": 336,
                "label": "遂宁",
                "children": [{
                    "value": 2873,
                    "label": "蓬溪县",
                    "children": []
                  },
                  {
                    "value": 2874,
                    "label": "射洪县",
                    "children": []
                  }
                ]
              },
              {
                "value": 337,
                "label": "雅安",
                "children": [{
                    "value": 2877,
                    "label": "名山县",
                    "children": []
                  },
                  {
                    "value": 2878,
                    "label": "荥经县",
                    "children": []
                  },
                  {
                    "value": 2879,
                    "label": "汉源县",
                    "children": []
                  },
                  {
                    "value": 2880,
                    "label": "石棉县",
                    "children": []
                  },
                  {
                    "value": 2881,
                    "label": "天全县",
                    "children": []
                  },
                  {
                    "value": 2882,
                    "label": "芦山县",
                    "children": []
                  },
                  {
                    "value": 2883,
                    "label": "宝兴县",
                    "children": []
                  }
                ]
              },
              {
                "value": 338,
                "label": "宜宾",
                "children": [{
                    "value": 2885,
                    "label": "宜宾县",
                    "children": []
                  },
                  {
                    "value": 2886,
                    "label": "南溪县",
                    "children": []
                  },
                  {
                    "value": 2887,
                    "label": "江安县",
                    "children": []
                  },
                  {
                    "value": 2888,
                    "label": "长宁县",
                    "children": []
                  },
                  {
                    "value": 2889,
                    "label": "高县",
                    "children": []
                  },
                  {
                    "value": 2890,
                    "label": "珙县",
                    "children": []
                  },
                  {
                    "value": 2891,
                    "label": "筠连县",
                    "children": []
                  },
                  {
                    "value": 2892,
                    "label": "兴文县",
                    "children": []
                  },
                  {
                    "value": 2893,
                    "label": "屏山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 339,
                "label": "资阳",
                "children": [{
                    "value": 2896,
                    "label": "安岳县",
                    "children": []
                  },
                  {
                    "value": 2897,
                    "label": "乐至县",
                    "children": []
                  }
                ]
              },
              {
                "value": 340,
                "label": "自贡",
                "children": [{
                    "value": 2902,
                    "label": "荣县",
                    "children": []
                  },
                  {
                    "value": 2903,
                    "label": "富顺县",
                    "children": []
                  }
                ]
              },
              {
                "value": 341,
                "label": "泸州",
                "children": [{
                    "value": 2905,
                    "label": "纳溪区",
                    "children": []
                  },
                  {
                    "value": 2907,
                    "label": "泸县",
                    "children": []
                  },
                  {
                    "value": 2908,
                    "label": "合江县",
                    "children": []
                  },
                  {
                    "value": 2909,
                    "label": "叙永县",
                    "children": []
                  },
                  {
                    "value": 2910,
                    "label": "古蔺县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 26,
            "label": "天津",
            "children": [{
                "value": 2917,
                "label": "东丽区",
                "children": []
              },
              {
                "value": 2918,
                "label": "津南区",
                "children": []
              },
              {
                "value": 2919,
                "label": "西青区",
                "children": []
              },
              {
                "value": 2920,
                "label": "北辰区",
                "children": []
              },
              {
                "value": 2921,
                "label": "塘沽区",
                "children": []
              },
              {
                "value": 2922,
                "label": "汉沽区",
                "children": []
              },
              {
                "value": 2923,
                "label": "大港区",
                "children": []
              },
              {
                "value": 2924,
                "label": "武清区",
                "children": []
              },
              {
                "value": 2925,
                "label": "宝坻区",
                "children": []
              },
              {
                "value": 2927,
                "label": "宁河区",
                "children": []
              },
              {
                "value": 2928,
                "label": "静海区",
                "children": []
              },
              {
                "value": 2929,
                "label": "蓟州区",
                "children": []
              }
            ]
          },
          {
            "value": 27,
            "label": "西藏",
            "children": [{
                "value": 343,
                "label": "拉萨",
                "children": [{
                    "value": 2931,
                    "label": "林周县",
                    "children": []
                  },
                  {
                    "value": 2932,
                    "label": "当雄县",
                    "children": []
                  },
                  {
                    "value": 2933,
                    "label": "尼木县",
                    "children": []
                  },
                  {
                    "value": 2934,
                    "label": "曲水县",
                    "children": []
                  },
                  {
                    "value": 2935,
                    "label": "堆龙德庆县",
                    "children": []
                  },
                  {
                    "value": 2936,
                    "label": "达孜县",
                    "children": []
                  },
                  {
                    "value": 2937,
                    "label": "墨竹工卡县",
                    "children": []
                  }
                ]
              },
              {
                "value": 344,
                "label": "阿里",
                "children": [{
                    "value": 2938,
                    "label": "噶尔县",
                    "children": []
                  },
                  {
                    "value": 2939,
                    "label": "普兰县",
                    "children": []
                  },
                  {
                    "value": 2940,
                    "label": "札达县",
                    "children": []
                  },
                  {
                    "value": 2941,
                    "label": "日土县",
                    "children": []
                  },
                  {
                    "value": 2942,
                    "label": "革吉县",
                    "children": []
                  },
                  {
                    "value": 2943,
                    "label": "改则县",
                    "children": []
                  },
                  {
                    "value": 2944,
                    "label": "措勤县",
                    "children": []
                  }
                ]
              },
              {
                "value": 345,
                "label": "昌都",
                "children": [{
                    "value": 2945,
                    "label": "昌都县",
                    "children": []
                  },
                  {
                    "value": 2946,
                    "label": "江达县",
                    "children": []
                  },
                  {
                    "value": 2947,
                    "label": "贡觉县",
                    "children": []
                  },
                  {
                    "value": 2948,
                    "label": "类乌齐县",
                    "children": []
                  },
                  {
                    "value": 2949,
                    "label": "丁青县",
                    "children": []
                  },
                  {
                    "value": 2950,
                    "label": "察雅县",
                    "children": []
                  },
                  {
                    "value": 2951,
                    "label": "八宿县",
                    "children": []
                  },
                  {
                    "value": 2952,
                    "label": "左贡县",
                    "children": []
                  },
                  {
                    "value": 2953,
                    "label": "芒康县",
                    "children": []
                  },
                  {
                    "value": 2954,
                    "label": "洛隆县",
                    "children": []
                  },
                  {
                    "value": 2955,
                    "label": "边坝县",
                    "children": []
                  }
                ]
              },
              {
                "value": 346,
                "label": "林芝",
                "children": [{
                    "value": 2956,
                    "label": "林芝县",
                    "children": []
                  },
                  {
                    "value": 2957,
                    "label": "工布江达县",
                    "children": []
                  },
                  {
                    "value": 2958,
                    "label": "米林县",
                    "children": []
                  },
                  {
                    "value": 2959,
                    "label": "墨脱县",
                    "children": []
                  },
                  {
                    "value": 2960,
                    "label": "波密县",
                    "children": []
                  },
                  {
                    "value": 2961,
                    "label": "察隅县",
                    "children": []
                  },
                  {
                    "value": 2962,
                    "label": "朗县",
                    "children": []
                  }
                ]
              },
              {
                "value": 347,
                "label": "那曲",
                "children": [{
                    "value": 2963,
                    "label": "那曲县",
                    "children": []
                  },
                  {
                    "value": 2964,
                    "label": "嘉黎县",
                    "children": []
                  },
                  {
                    "value": 2965,
                    "label": "比如县",
                    "children": []
                  },
                  {
                    "value": 2966,
                    "label": "聂荣县",
                    "children": []
                  },
                  {
                    "value": 2967,
                    "label": "安多县",
                    "children": []
                  },
                  {
                    "value": 2968,
                    "label": "申扎县",
                    "children": []
                  },
                  {
                    "value": 2969,
                    "label": "索县",
                    "children": []
                  },
                  {
                    "value": 2970,
                    "label": "班戈县",
                    "children": []
                  },
                  {
                    "value": 2971,
                    "label": "巴青县",
                    "children": []
                  },
                  {
                    "value": 2972,
                    "label": "尼玛县",
                    "children": []
                  }
                ]
              },
              {
                "value": 348,
                "label": "日喀则",
                "children": [{
                    "value": 2973,
                    "label": "日喀则市",
                    "children": []
                  },
                  {
                    "value": 2974,
                    "label": "南木林县",
                    "children": []
                  },
                  {
                    "value": 2975,
                    "label": "江孜县",
                    "children": []
                  },
                  {
                    "value": 2976,
                    "label": "定日县",
                    "children": []
                  },
                  {
                    "value": 2977,
                    "label": "萨迦县",
                    "children": []
                  },
                  {
                    "value": 2978,
                    "label": "拉孜县",
                    "children": []
                  },
                  {
                    "value": 2979,
                    "label": "昂仁县",
                    "children": []
                  },
                  {
                    "value": 2980,
                    "label": "谢通门县",
                    "children": []
                  },
                  {
                    "value": 2981,
                    "label": "白朗县",
                    "children": []
                  },
                  {
                    "value": 2982,
                    "label": "仁布县",
                    "children": []
                  },
                  {
                    "value": 2983,
                    "label": "康马县",
                    "children": []
                  },
                  {
                    "value": 2984,
                    "label": "定结县",
                    "children": []
                  },
                  {
                    "value": 2985,
                    "label": "仲巴县",
                    "children": []
                  },
                  {
                    "value": 2986,
                    "label": "亚东县",
                    "children": []
                  },
                  {
                    "value": 2987,
                    "label": "吉隆县",
                    "children": []
                  },
                  {
                    "value": 2988,
                    "label": "聂拉木县",
                    "children": []
                  },
                  {
                    "value": 2989,
                    "label": "萨嘎县",
                    "children": []
                  },
                  {
                    "value": 2990,
                    "label": "岗巴县",
                    "children": []
                  }
                ]
              },
              {
                "value": 349,
                "label": "山南",
                "children": [{
                    "value": 2991,
                    "label": "乃东县",
                    "children": []
                  },
                  {
                    "value": 2992,
                    "label": "扎囊县",
                    "children": []
                  },
                  {
                    "value": 2993,
                    "label": "贡嘎县",
                    "children": []
                  },
                  {
                    "value": 2994,
                    "label": "桑日县",
                    "children": []
                  },
                  {
                    "value": 2995,
                    "label": "琼结县",
                    "children": []
                  },
                  {
                    "value": 2996,
                    "label": "曲松县",
                    "children": []
                  },
                  {
                    "value": 2997,
                    "label": "措美县",
                    "children": []
                  },
                  {
                    "value": 2998,
                    "label": "洛扎县",
                    "children": []
                  },
                  {
                    "value": 2999,
                    "label": "加查县",
                    "children": []
                  },
                  {
                    "value": 3000,
                    "label": "隆子县",
                    "children": []
                  },
                  {
                    "value": 3001,
                    "label": "错那县",
                    "children": []
                  },
                  {
                    "value": 3002,
                    "label": "浪卡子县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 28,
            "label": "新疆",
            "children": [{
                "value": 350,
                "label": "乌鲁木齐",
                "children": [{
                    "value": 3008,
                    "label": "达坂城区",
                    "children": []
                  },
                  {
                    "value": 3010,
                    "label": "乌鲁木齐县",
                    "children": []
                  }
                ]
              },
              {
                "value": 351,
                "label": "阿克苏",
                "children": [{
                    "value": 3011,
                    "label": "阿克苏市",
                    "children": []
                  },
                  {
                    "value": 3012,
                    "label": "温宿县",
                    "children": []
                  },
                  {
                    "value": 3013,
                    "label": "库车县",
                    "children": []
                  },
                  {
                    "value": 3014,
                    "label": "沙雅县",
                    "children": []
                  },
                  {
                    "value": 3015,
                    "label": "新和县",
                    "children": []
                  },
                  {
                    "value": 3016,
                    "label": "拜城县",
                    "children": []
                  },
                  {
                    "value": 3017,
                    "label": "乌什县",
                    "children": []
                  },
                  {
                    "value": 3018,
                    "label": "阿瓦提县",
                    "children": []
                  },
                  {
                    "value": 3019,
                    "label": "柯坪县",
                    "children": []
                  }
                ]
              },
              {
                "value": 352,
                "label": "阿拉尔",
                "children": [{
                  "value": 3020,
                  "label": "阿拉尔市",
                  "children": []
                }]
              },
              {
                "value": 353,
                "label": "巴音郭楞",
                "children": [{
                    "value": 3021,
                    "label": "库尔勒",
                    "children": []
                  },
                  {
                    "value": 3022,
                    "label": "轮台县",
                    "children": []
                  },
                  {
                    "value": 3023,
                    "label": "尉犁县",
                    "children": []
                  },
                  {
                    "value": 3024,
                    "label": "若羌县",
                    "children": []
                  },
                  {
                    "value": 3025,
                    "label": "且末县",
                    "children": []
                  },
                  {
                    "value": 3026,
                    "label": "焉耆县",
                    "children": []
                  },
                  {
                    "value": 3027,
                    "label": "和静县",
                    "children": []
                  },
                  {
                    "value": 3028,
                    "label": "和硕县",
                    "children": []
                  },
                  {
                    "value": 3029,
                    "label": "博湖县",
                    "children": []
                  }
                ]
              },
              {
                "value": 354,
                "label": "博尔塔拉",
                "children": [{
                    "value": 3030,
                    "label": "博乐市",
                    "children": []
                  },
                  {
                    "value": 3031,
                    "label": "精河县",
                    "children": []
                  },
                  {
                    "value": 3032,
                    "label": "温泉县",
                    "children": []
                  }
                ]
              },
              {
                "value": 355,
                "label": "昌吉",
                "children": [{
                    "value": 3033,
                    "label": "呼图壁县",
                    "children": []
                  },
                  {
                    "value": 3034,
                    "label": "米泉市",
                    "children": []
                  },
                  {
                    "value": 3035,
                    "label": "昌吉市",
                    "children": []
                  },
                  {
                    "value": 3036,
                    "label": "阜康市",
                    "children": []
                  },
                  {
                    "value": 3037,
                    "label": "玛纳斯县",
                    "children": []
                  },
                  {
                    "value": 3038,
                    "label": "奇台县",
                    "children": []
                  },
                  {
                    "value": 3039,
                    "label": "吉木萨尔县",
                    "children": []
                  },
                  {
                    "value": 3040,
                    "label": "木垒县",
                    "children": []
                  }
                ]
              },
              {
                "value": 356,
                "label": "哈密",
                "children": [{
                    "value": 3041,
                    "label": "哈密市",
                    "children": []
                  },
                  {
                    "value": 3042,
                    "label": "伊吾县",
                    "children": []
                  },
                  {
                    "value": 3043,
                    "label": "巴里坤",
                    "children": []
                  }
                ]
              },
              {
                "value": 357,
                "label": "和田",
                "children": [{
                    "value": 3044,
                    "label": "和田市",
                    "children": []
                  },
                  {
                    "value": 3045,
                    "label": "和田县",
                    "children": []
                  },
                  {
                    "value": 3046,
                    "label": "墨玉县",
                    "children": []
                  },
                  {
                    "value": 3047,
                    "label": "皮山县",
                    "children": []
                  },
                  {
                    "value": 3048,
                    "label": "洛浦县",
                    "children": []
                  },
                  {
                    "value": 3049,
                    "label": "策勒县",
                    "children": []
                  },
                  {
                    "value": 3050,
                    "label": "于田县",
                    "children": []
                  },
                  {
                    "value": 3051,
                    "label": "民丰县",
                    "children": []
                  }
                ]
              },
              {
                "value": 358,
                "label": "喀什",
                "children": [{
                    "value": 3052,
                    "label": "喀什市",
                    "children": []
                  },
                  {
                    "value": 3053,
                    "label": "疏附县",
                    "children": []
                  },
                  {
                    "value": 3054,
                    "label": "疏勒县",
                    "children": []
                  },
                  {
                    "value": 3055,
                    "label": "英吉沙县",
                    "children": []
                  },
                  {
                    "value": 3056,
                    "label": "泽普县",
                    "children": []
                  },
                  {
                    "value": 3057,
                    "label": "莎车县",
                    "children": []
                  },
                  {
                    "value": 3058,
                    "label": "叶城县",
                    "children": []
                  },
                  {
                    "value": 3059,
                    "label": "麦盖提县",
                    "children": []
                  },
                  {
                    "value": 3060,
                    "label": "岳普湖县",
                    "children": []
                  },
                  {
                    "value": 3061,
                    "label": "伽师县",
                    "children": []
                  },
                  {
                    "value": 3062,
                    "label": "巴楚县",
                    "children": []
                  },
                  {
                    "value": 3063,
                    "label": "塔什库尔干",
                    "children": []
                  }
                ]
              },
              {
                "value": 359,
                "label": "克拉玛依",
                "children": [{
                  "value": 3064,
                  "label": "克拉玛依市",
                  "children": []
                }]
              },
              {
                "value": 360,
                "label": "克孜勒苏",
                "children": [{
                    "value": 3065,
                    "label": "阿图什市",
                    "children": []
                  },
                  {
                    "value": 3066,
                    "label": "阿克陶县",
                    "children": []
                  },
                  {
                    "value": 3067,
                    "label": "阿合奇县",
                    "children": []
                  },
                  {
                    "value": 3068,
                    "label": "乌恰县",
                    "children": []
                  }
                ]
              },
              {
                "value": 361,
                "label": "石河子",
                "children": [{
                  "value": 3069,
                  "label": "石河子市",
                  "children": []
                }]
              },
              {
                "value": 362,
                "label": "图木舒克",
                "children": []
              },
              {
                "value": 363,
                "label": "吐鲁番",
                "children": [{
                    "value": 3071,
                    "label": "吐鲁番市",
                    "children": []
                  },
                  {
                    "value": 3072,
                    "label": "鄯善县",
                    "children": []
                  },
                  {
                    "value": 3073,
                    "label": "托克逊县",
                    "children": []
                  }
                ]
              },
              {
                "value": 364,
                "label": "五家渠",
                "children": []
              },
              {
                "value": 365,
                "label": "伊犁",
                "children": [{
                    "value": 3075,
                    "label": "阿勒泰",
                    "children": []
                  },
                  {
                    "value": 3076,
                    "label": "和布克赛尔",
                    "children": []
                  },
                  {
                    "value": 3077,
                    "label": "伊宁市",
                    "children": []
                  },
                  {
                    "value": 3078,
                    "label": "布尔津县",
                    "children": []
                  },
                  {
                    "value": 3079,
                    "label": "奎屯市",
                    "children": []
                  },
                  {
                    "value": 3080,
                    "label": "乌苏市",
                    "children": []
                  },
                  {
                    "value": 3081,
                    "label": "额敏县",
                    "children": []
                  },
                  {
                    "value": 3082,
                    "label": "富蕴县",
                    "children": []
                  },
                  {
                    "value": 3083,
                    "label": "伊宁县",
                    "children": []
                  },
                  {
                    "value": 3084,
                    "label": "福海县",
                    "children": []
                  },
                  {
                    "value": 3085,
                    "label": "霍城县",
                    "children": []
                  },
                  {
                    "value": 3086,
                    "label": "沙湾县",
                    "children": []
                  },
                  {
                    "value": 3087,
                    "label": "巩留县",
                    "children": []
                  },
                  {
                    "value": 3088,
                    "label": "哈巴河县",
                    "children": []
                  },
                  {
                    "value": 3089,
                    "label": "托里县",
                    "children": []
                  },
                  {
                    "value": 3090,
                    "label": "青河县",
                    "children": []
                  },
                  {
                    "value": 3091,
                    "label": "新源县",
                    "children": []
                  },
                  {
                    "value": 3092,
                    "label": "裕民县",
                    "children": []
                  },
                  {
                    "value": 3094,
                    "label": "吉木乃县",
                    "children": []
                  },
                  {
                    "value": 3095,
                    "label": "昭苏县",
                    "children": []
                  },
                  {
                    "value": 3096,
                    "label": "特克斯县",
                    "children": []
                  },
                  {
                    "value": 3097,
                    "label": "尼勒克县",
                    "children": []
                  },
                  {
                    "value": 3098,
                    "label": "察布查尔",
                    "children": []
                  },
                  {
                    "value": 1856,
                    "label": "塔城市",
                    "children": []
                  }
                ]
              },
              {
                "value": 3657,
                "label": "北屯",
                "children": []
              }
            ]
          },
          {
            "value": 29,
            "label": "云南",
            "children": [{
                "value": 366,
                "label": "昆明",
                "children": [{
                    "value": 3103,
                    "label": "东川区",
                    "children": []
                  },
                  {
                    "value": 3104,
                    "label": "安宁市",
                    "children": []
                  },
                  {
                    "value": 3105,
                    "label": "呈贡县",
                    "children": []
                  },
                  {
                    "value": 3106,
                    "label": "晋宁县",
                    "children": []
                  },
                  {
                    "value": 3107,
                    "label": "富民县",
                    "children": []
                  },
                  {
                    "value": 3108,
                    "label": "宜良县",
                    "children": []
                  },
                  {
                    "value": 3109,
                    "label": "嵩明县",
                    "children": []
                  },
                  {
                    "value": 3110,
                    "label": "石林县",
                    "children": []
                  },
                  {
                    "value": 3111,
                    "label": "禄劝县",
                    "children": []
                  },
                  {
                    "value": 3112,
                    "label": "寻甸县",
                    "children": []
                  }
                ]
              },
              {
                "value": 367,
                "label": "怒江",
                "children": [{
                    "value": 3113,
                    "label": "兰坪县",
                    "children": []
                  },
                  {
                    "value": 3114,
                    "label": "泸水县",
                    "children": []
                  },
                  {
                    "value": 3115,
                    "label": "福贡县",
                    "children": []
                  },
                  {
                    "value": 3116,
                    "label": "贡山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 368,
                "label": "普洱",
                "children": [{
                    "value": 3117,
                    "label": "宁洱县",
                    "children": []
                  },
                  {
                    "value": 3118,
                    "label": "思茅区",
                    "children": []
                  },
                  {
                    "value": 3119,
                    "label": "墨江县",
                    "children": []
                  },
                  {
                    "value": 3120,
                    "label": "景东县",
                    "children": []
                  },
                  {
                    "value": 3121,
                    "label": "景谷县",
                    "children": []
                  },
                  {
                    "value": 3122,
                    "label": "镇沅县",
                    "children": []
                  },
                  {
                    "value": 3123,
                    "label": "江城县",
                    "children": []
                  },
                  {
                    "value": 3124,
                    "label": "孟连县",
                    "children": []
                  },
                  {
                    "value": 3125,
                    "label": "澜沧县",
                    "children": []
                  },
                  {
                    "value": 3126,
                    "label": "西盟县",
                    "children": []
                  }
                ]
              },
              {
                "value": 369,
                "label": "丽江",
                "children": [{
                    "value": 3128,
                    "label": "宁蒗县",
                    "children": []
                  },
                  {
                    "value": 3130,
                    "label": "永胜县",
                    "children": []
                  },
                  {
                    "value": 3131,
                    "label": "华坪县",
                    "children": []
                  }
                ]
              },
              {
                "value": 370,
                "label": "保山",
                "children": [{
                    "value": 3133,
                    "label": "施甸县",
                    "children": []
                  },
                  {
                    "value": 3134,
                    "label": "腾冲县",
                    "children": []
                  },
                  {
                    "value": 3135,
                    "label": "龙陵县",
                    "children": []
                  },
                  {
                    "value": 3136,
                    "label": "昌宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 371,
                "label": "楚雄",
                "children": [{
                    "value": 3137,
                    "label": "楚雄市",
                    "children": []
                  },
                  {
                    "value": 3138,
                    "label": "双柏县",
                    "children": []
                  },
                  {
                    "value": 3139,
                    "label": "牟定县",
                    "children": []
                  },
                  {
                    "value": 3140,
                    "label": "南华县",
                    "children": []
                  },
                  {
                    "value": 3141,
                    "label": "姚安县",
                    "children": []
                  },
                  {
                    "value": 3142,
                    "label": "大姚县",
                    "children": []
                  },
                  {
                    "value": 3143,
                    "label": "永仁县",
                    "children": []
                  },
                  {
                    "value": 3144,
                    "label": "元谋县",
                    "children": []
                  },
                  {
                    "value": 3145,
                    "label": "武定县",
                    "children": []
                  },
                  {
                    "value": 3146,
                    "label": "禄丰县",
                    "children": []
                  }
                ]
              },
              {
                "value": 372,
                "label": "大理",
                "children": [{
                    "value": 3147,
                    "label": "大理市",
                    "children": []
                  },
                  {
                    "value": 3148,
                    "label": "祥云县",
                    "children": []
                  },
                  {
                    "value": 3149,
                    "label": "宾川县",
                    "children": []
                  },
                  {
                    "value": 3150,
                    "label": "弥渡县",
                    "children": []
                  },
                  {
                    "value": 3151,
                    "label": "永平县",
                    "children": []
                  },
                  {
                    "value": 3152,
                    "label": "云龙县",
                    "children": []
                  },
                  {
                    "value": 3153,
                    "label": "洱源县",
                    "children": []
                  },
                  {
                    "value": 3154,
                    "label": "剑川县",
                    "children": []
                  },
                  {
                    "value": 3155,
                    "label": "鹤庆县",
                    "children": []
                  },
                  {
                    "value": 3156,
                    "label": "漾濞县",
                    "children": []
                  },
                  {
                    "value": 3157,
                    "label": "南涧县",
                    "children": []
                  },
                  {
                    "value": 3158,
                    "label": "巍山县",
                    "children": []
                  }
                ]
              },
              {
                "value": 373,
                "label": "德宏",
                "children": [{
                    "value": 3159,
                    "label": "潞西市",
                    "children": []
                  },
                  {
                    "value": 3160,
                    "label": "瑞丽市",
                    "children": []
                  },
                  {
                    "value": 3161,
                    "label": "梁河县",
                    "children": []
                  },
                  {
                    "value": 3162,
                    "label": "盈江县",
                    "children": []
                  },
                  {
                    "value": 3163,
                    "label": "陇川县",
                    "children": []
                  }
                ]
              },
              {
                "value": 374,
                "label": "迪庆",
                "children": [{
                    "value": 3164,
                    "label": "香格里拉县",
                    "children": []
                  },
                  {
                    "value": 3165,
                    "label": "德钦县",
                    "children": []
                  },
                  {
                    "value": 3166,
                    "label": "维西县",
                    "children": []
                  }
                ]
              },
              {
                "value": 375,
                "label": "红河",
                "children": [{
                    "value": 3167,
                    "label": "泸西县",
                    "children": []
                  },
                  {
                    "value": 3168,
                    "label": "蒙自市",
                    "children": []
                  },
                  {
                    "value": 3169,
                    "label": "个旧市",
                    "children": []
                  },
                  {
                    "value": 3170,
                    "label": "开远市",
                    "children": []
                  },
                  {
                    "value": 3171,
                    "label": "绿春县",
                    "children": []
                  },
                  {
                    "value": 3172,
                    "label": "建水县",
                    "children": []
                  },
                  {
                    "value": 3173,
                    "label": "石屏县",
                    "children": []
                  },
                  {
                    "value": 3174,
                    "label": "弥勒县",
                    "children": []
                  },
                  {
                    "value": 3175,
                    "label": "元阳县",
                    "children": []
                  },
                  {
                    "value": 3176,
                    "label": "红河县",
                    "children": []
                  },
                  {
                    "value": 3177,
                    "label": "金平县",
                    "children": []
                  },
                  {
                    "value": 3178,
                    "label": "河口县",
                    "children": []
                  },
                  {
                    "value": 3179,
                    "label": "屏边县",
                    "children": []
                  }
                ]
              },
              {
                "value": 376,
                "label": "临沧",
                "children": [{
                    "value": 3181,
                    "label": "凤庆县",
                    "children": []
                  },
                  {
                    "value": 3182,
                    "label": "云县",
                    "children": []
                  },
                  {
                    "value": 3183,
                    "label": "永德县",
                    "children": []
                  },
                  {
                    "value": 3184,
                    "label": "镇康县",
                    "children": []
                  },
                  {
                    "value": 3185,
                    "label": "双江县",
                    "children": []
                  },
                  {
                    "value": 3186,
                    "label": "耿马县",
                    "children": []
                  },
                  {
                    "value": 3187,
                    "label": "沧源县",
                    "children": []
                  }
                ]
              },
              {
                "value": 377,
                "label": "曲靖",
                "children": [{
                    "value": 3189,
                    "label": "宣威市",
                    "children": []
                  },
                  {
                    "value": 3190,
                    "label": "马龙县",
                    "children": []
                  },
                  {
                    "value": 3191,
                    "label": "陆良县",
                    "children": []
                  },
                  {
                    "value": 3192,
                    "label": "师宗县",
                    "children": []
                  },
                  {
                    "value": 3193,
                    "label": "罗平县",
                    "children": []
                  },
                  {
                    "value": 3194,
                    "label": "富源县",
                    "children": []
                  },
                  {
                    "value": 3195,
                    "label": "会泽县",
                    "children": []
                  },
                  {
                    "value": 3196,
                    "label": "沾益县",
                    "children": []
                  }
                ]
              },
              {
                "value": 378,
                "label": "文山",
                "children": [{
                    "value": 3197,
                    "label": "文山县",
                    "children": []
                  },
                  {
                    "value": 3198,
                    "label": "砚山县",
                    "children": []
                  },
                  {
                    "value": 3199,
                    "label": "西畴县",
                    "children": []
                  },
                  {
                    "value": 3200,
                    "label": "麻栗坡县",
                    "children": []
                  },
                  {
                    "value": 3201,
                    "label": "马关县",
                    "children": []
                  },
                  {
                    "value": 3202,
                    "label": "丘北县",
                    "children": []
                  },
                  {
                    "value": 3203,
                    "label": "广南县",
                    "children": []
                  },
                  {
                    "value": 3204,
                    "label": "富宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 379,
                "label": "西双版纳",
                "children": [{
                    "value": 3205,
                    "label": "景洪市",
                    "children": []
                  },
                  {
                    "value": 3206,
                    "label": "勐海县",
                    "children": []
                  },
                  {
                    "value": 3207,
                    "label": "勐腊县",
                    "children": []
                  }
                ]
              },
              {
                "value": 380,
                "label": "玉溪",
                "children": [{
                    "value": 3209,
                    "label": "江川县",
                    "children": []
                  },
                  {
                    "value": 3210,
                    "label": "澄江县",
                    "children": []
                  },
                  {
                    "value": 3211,
                    "label": "通海县",
                    "children": []
                  },
                  {
                    "value": 3212,
                    "label": "华宁县",
                    "children": []
                  },
                  {
                    "value": 3213,
                    "label": "易门县",
                    "children": []
                  },
                  {
                    "value": 3214,
                    "label": "峨山县",
                    "children": []
                  },
                  {
                    "value": 3215,
                    "label": "新平县",
                    "children": []
                  },
                  {
                    "value": 3216,
                    "label": "元江县",
                    "children": []
                  }
                ]
              },
              {
                "value": 381,
                "label": "昭通",
                "children": [{
                    "value": 3218,
                    "label": "鲁甸县",
                    "children": []
                  },
                  {
                    "value": 3219,
                    "label": "巧家县",
                    "children": []
                  },
                  {
                    "value": 3220,
                    "label": "盐津县",
                    "children": []
                  },
                  {
                    "value": 3221,
                    "label": "大关县",
                    "children": []
                  },
                  {
                    "value": 3222,
                    "label": "永善县",
                    "children": []
                  },
                  {
                    "value": 3223,
                    "label": "绥江县",
                    "children": []
                  },
                  {
                    "value": 3224,
                    "label": "镇雄县",
                    "children": []
                  },
                  {
                    "value": 3225,
                    "label": "彝良县",
                    "children": []
                  },
                  {
                    "value": 3226,
                    "label": "威信县",
                    "children": []
                  },
                  {
                    "value": 3227,
                    "label": "水富县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 30,
            "label": "浙江",
            "children": [{
                "value": 382,
                "label": "杭州",
                "children": [{
                    "value": 3234,
                    "label": "萧山区",
                    "children": []
                  },
                  {
                    "value": 3235,
                    "label": "余杭区",
                    "children": []
                  },
                  {
                    "value": 3237,
                    "label": "建德市",
                    "children": []
                  },
                  {
                    "value": 3238,
                    "label": "富阳区",
                    "children": []
                  },
                  {
                    "value": 3239,
                    "label": "临安市",
                    "children": []
                  },
                  {
                    "value": 3240,
                    "label": "桐庐县",
                    "children": []
                  },
                  {
                    "value": 3241,
                    "label": "淳安县",
                    "children": []
                  }
                ]
              },
              {
                "value": 383,
                "label": "湖州",
                "children": [{
                    "value": 3244,
                    "label": "德清县",
                    "children": []
                  },
                  {
                    "value": 3245,
                    "label": "长兴县",
                    "children": []
                  },
                  {
                    "value": 3246,
                    "label": "安吉县",
                    "children": []
                  }
                ]
              },
              {
                "value": 384,
                "label": "嘉兴",
                "children": [{
                    "value": 3249,
                    "label": "海宁市",
                    "children": []
                  },
                  {
                    "value": 3250,
                    "label": "嘉善县",
                    "children": []
                  },
                  {
                    "value": 3251,
                    "label": "平湖市",
                    "children": []
                  },
                  {
                    "value": 3252,
                    "label": "桐乡市",
                    "children": []
                  },
                  {
                    "value": 3253,
                    "label": "海盐县",
                    "children": []
                  }
                ]
              },
              {
                "value": 385,
                "label": "金华",
                "children": [{
                    "value": 3256,
                    "label": "兰溪市",
                    "children": []
                  },
                  {
                    "value": 3257,
                    "label": "义乌市",
                    "children": []
                  },
                  {
                    "value": 3264,
                    "label": "东阳市",
                    "children": []
                  },
                  {
                    "value": 3265,
                    "label": "永康市",
                    "children": []
                  },
                  {
                    "value": 3266,
                    "label": "武义县",
                    "children": []
                  },
                  {
                    "value": 3267,
                    "label": "浦江县",
                    "children": []
                  },
                  {
                    "value": 3268,
                    "label": "磐安县",
                    "children": []
                  }
                ]
              },
              {
                "value": 386,
                "label": "丽水",
                "children": [{
                    "value": 3270,
                    "label": "龙泉市",
                    "children": []
                  },
                  {
                    "value": 3271,
                    "label": "青田县",
                    "children": []
                  },
                  {
                    "value": 3272,
                    "label": "缙云县",
                    "children": []
                  },
                  {
                    "value": 3273,
                    "label": "遂昌县",
                    "children": []
                  },
                  {
                    "value": 3274,
                    "label": "松阳县",
                    "children": []
                  },
                  {
                    "value": 3275,
                    "label": "云和县",
                    "children": []
                  },
                  {
                    "value": 3276,
                    "label": "庆元县",
                    "children": []
                  },
                  {
                    "value": 3277,
                    "label": "景宁县",
                    "children": []
                  }
                ]
              },
              {
                "value": 387,
                "label": "宁波",
                "children": [{
                    "value": 3281,
                    "label": "镇海区",
                    "children": []
                  },
                  {
                    "value": 3282,
                    "label": "北仑区",
                    "children": []
                  },
                  {
                    "value": 3283,
                    "label": "鄞州区",
                    "children": []
                  },
                  {
                    "value": 3284,
                    "label": "余姚市",
                    "children": []
                  },
                  {
                    "value": 3285,
                    "label": "慈溪市",
                    "children": []
                  },
                  {
                    "value": 3286,
                    "label": "奉化区",
                    "children": []
                  },
                  {
                    "value": 3287,
                    "label": "象山县",
                    "children": []
                  },
                  {
                    "value": 3288,
                    "label": "宁海县",
                    "children": []
                  }
                ]
              },
              {
                "value": 388,
                "label": "绍兴",
                "children": [{
                    "value": 3290,
                    "label": "上虞区",
                    "children": []
                  },
                  {
                    "value": 3291,
                    "label": "嵊州市",
                    "children": []
                  },
                  {
                    "value": 3292,
                    "label": "绍兴县",
                    "children": []
                  },
                  {
                    "value": 3293,
                    "label": "新昌县",
                    "children": []
                  },
                  {
                    "value": 3294,
                    "label": "诸暨市",
                    "children": []
                  }
                ]
              },
              {
                "value": 389,
                "label": "台州",
                "children": [{
                    "value": 3295,
                    "label": "椒江区",
                    "children": []
                  },
                  {
                    "value": 3296,
                    "label": "黄岩区",
                    "children": []
                  },
                  {
                    "value": 3297,
                    "label": "路桥区",
                    "children": []
                  },
                  {
                    "value": 3298,
                    "label": "温岭市",
                    "children": []
                  },
                  {
                    "value": 3299,
                    "label": "临海市",
                    "children": []
                  },
                  {
                    "value": 3300,
                    "label": "玉环县",
                    "children": []
                  },
                  {
                    "value": 3301,
                    "label": "三门县",
                    "children": []
                  },
                  {
                    "value": 3302,
                    "label": "天台县",
                    "children": []
                  },
                  {
                    "value": 3303,
                    "label": "仙居县",
                    "children": []
                  }
                ]
              },
              {
                "value": 390,
                "label": "温州",
                "children": [{
                    "value": 3307,
                    "label": "瑞安市",
                    "children": []
                  },
                  {
                    "value": 3308,
                    "label": "乐清市",
                    "children": []
                  },
                  {
                    "value": 3309,
                    "label": "洞头区",
                    "children": []
                  },
                  {
                    "value": 3310,
                    "label": "永嘉县",
                    "children": []
                  },
                  {
                    "value": 3311,
                    "label": "平阳县",
                    "children": []
                  },
                  {
                    "value": 3312,
                    "label": "苍南县",
                    "children": []
                  },
                  {
                    "value": 3313,
                    "label": "文成县",
                    "children": []
                  },
                  {
                    "value": 3314,
                    "label": "泰顺县",
                    "children": []
                  }
                ]
              },
              {
                "value": 391,
                "label": "舟山",
                "children": [{
                    "value": 3315,
                    "label": "定海区",
                    "children": []
                  },
                  {
                    "value": 3316,
                    "label": "普陀区",
                    "children": []
                  },
                  {
                    "value": 3317,
                    "label": "岱山县",
                    "children": []
                  },
                  {
                    "value": 3318,
                    "label": "嵊泗县",
                    "children": []
                  }
                ]
              },
              {
                "value": 392,
                "label": "衢州",
                "children": [{
                    "value": 3319,
                    "label": "衢江区",
                    "children": []
                  },
                  {
                    "value": 3320,
                    "label": "江山市",
                    "children": []
                  },
                  {
                    "value": 3321,
                    "label": "常山县",
                    "children": []
                  },
                  {
                    "value": 3322,
                    "label": "开化县",
                    "children": []
                  },
                  {
                    "value": 3323,
                    "label": "龙游县",
                    "children": []
                  }
                ]
              }
            ]
          },
          {
            "value": 31,
            "label": "重庆",
            "children": [{
                "value": 3324,
                "label": "合川区",
                "children": []
              },
              {
                "value": 3325,
                "label": "江津区",
                "children": []
              },
              {
                "value": 3326,
                "label": "南川区",
                "children": []
              },
              {
                "value": 3327,
                "label": "永川区",
                "children": []
              },
              {
                "value": 3329,
                "label": "渝北区",
                "children": []
              },
              {
                "value": 3330,
                "label": "万盛区",
                "children": []
              },
              {
                "value": 3332,
                "label": "万州区",
                "children": []
              },
              {
                "value": 3333,
                "label": "北碚区",
                "children": []
              },
              {
                "value": 3334,
                "label": "沙坪坝区",
                "children": []
              },
              {
                "value": 3335,
                "label": "巴南区",
                "children": []
              },
              {
                "value": 3336,
                "label": "涪陵区",
                "children": []
              },
              {
                "value": 3340,
                "label": "黔江区",
                "children": []
              },
              {
                "value": 3341,
                "label": "长寿区",
                "children": []
              },
              {
                "value": 3343,
                "label": "綦江区",
                "children": []
              },
              {
                "value": 3344,
                "label": "潼南区",
                "children": []
              },
              {
                "value": 3345,
                "label": "铜梁区",
                "children": []
              },
              {
                "value": 3346,
                "label": "大足县",
                "children": []
              },
              {
                "value": 3347,
                "label": "荣昌区",
                "children": []
              },
              {
                "value": 3348,
                "label": "璧山区",
                "children": []
              },
              {
                "value": 3349,
                "label": "垫江县",
                "children": []
              },
              {
                "value": 3350,
                "label": "武隆县",
                "children": []
              },
              {
                "value": 3351,
                "label": "丰都县",
                "children": []
              },
              {
                "value": 3352,
                "label": "城口县",
                "children": []
              },
              {
                "value": 3353,
                "label": "梁平县",
                "children": []
              },
              {
                "value": 3354,
                "label": "开县",
                "children": []
              },
              {
                "value": 3355,
                "label": "巫溪县",
                "children": []
              },
              {
                "value": 3356,
                "label": "巫山县",
                "children": []
              },
              {
                "value": 3357,
                "label": "奉节县",
                "children": []
              },
              {
                "value": 3358,
                "label": "云阳县",
                "children": []
              },
              {
                "value": 3359,
                "label": "忠县",
                "children": []
              },
              {
                "value": 3360,
                "label": "石柱县",
                "children": []
              },
              {
                "value": 3361,
                "label": "彭水县",
                "children": []
              },
              {
                "value": 3362,
                "label": "酉阳县",
                "children": []
              },
              {
                "value": 3363,
                "label": "秀山县",
                "children": []
              }
            ]
          },
          {
            "value": 32,
            "label": "香港",
            "children": [{
              "value": 3368,
              "label": "九龙城区",
              "children": []
            }]
          },
          {
            "value": 33,
            "label": "澳门",
            "children": []
          },
          {
            "value": 34,
            "label": "台湾",
            "children": [{
                "value": 3383,
                "label": "台北",
                "children": []
              },
              {
                "value": 3384,
                "label": "高雄",
                "children": []
              },
              {
                "value": 3385,
                "label": "基隆",
                "children": []
              },
              {
                "value": 3386,
                "label": "台中",
                "children": []
              },
              {
                "value": 3387,
                "label": "台南",
                "children": []
              },
              {
                "value": 3388,
                "label": "新竹",
                "children": []
              },
              {
                "value": 3389,
                "label": "嘉义",
                "children": []
              },
              {
                "value": 3390,
                "label": "宜兰县",
                "children": []
              },
              {
                "value": 3391,
                "label": "桃园县",
                "children": []
              },
              {
                "value": 3392,
                "label": "苗栗县",
                "children": []
              },
              {
                "value": 3393,
                "label": "彰化县",
                "children": []
              },
              {
                "value": 3394,
                "label": "南投县",
                "children": []
              },
              {
                "value": 3395,
                "label": "云林县",
                "children": []
              },
              {
                "value": 3396,
                "label": "屏东县",
                "children": []
              },
              {
                "value": 3397,
                "label": "台东县",
                "children": []
              },
              {
                "value": 3398,
                "label": "花莲县",
                "children": []
              }
            ]
          }
        ],

      }
    },
    methods: {
      sendChildData(){
          this.$emit('sendChildData',this.data.weathercity)
       }
    
    },

  }

</script>
<style lang="less">
</style>
