/*
 * Copyright (C) 2013 Telechips, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.telechips.android.tdmb;

public class EWSParser {

    public EWSParser() {
		ews_type = new String[][]
		{
			// �ҹ����û
			{"HRA", "\uD638\uC6B0 \uC8FC\uC758\uBCF4"}, 										// Heavy Rain Watch 						"ȣ�� ���Ǻ�"
			{"HRW", "\uD638\uC6B0 \uACBD\uBCF4"},												// Heavy Rain Warning						"ȣ�� �溸"
			{"HSW", "\uB300\uC124 \uC8FC\uC758\uBCF4"}, 										// Heavy Snow Watch						"�뼳 ���Ǻ�"
			{"HAS", "\uB300\uC124 \uACBD\uBCF4"},												// Heavy Snow Warning						"�뼳 �溸"
			{"SSA", "\uD3ED\uD48D\uD574\uC77C \uC8FC\uC758\uBCF4"}, 							// Storm Surge Watch						"��ǳ���� ���Ǻ�"
			{"SSW", "\uD3ED\uD48D\uD574\uC77C \uACBD\uBCF4"},									// Storm Surge Warning						"��ǳ���� �溸"
			{"YSW", "\uD669\uC0AC \uACBD\uBCF4"},												// Yellow Sand Warning						"Ȳ�� �溸"
			{"CWA", "\uD55C\uD30C \uC8FC\uC758\uBCF4"}, 										// Cold Wave Watch							"���� ���Ǻ�"
			{"CWW", "\uD55C\uD30C \uACBD\uBCF4"},												// Cold Wave Warning						"���� �溸"
			{"WWW", "\uD48D\uB791 \uACBD\uBCF4"},												// Wind and Waves Warning					"ǳ�� �溸"
			{"HAW", "\uAC74\uC870 \uACBD\uBCF4"},												// Heavy Arid Warning						"���� �溸"
			{"MFW", "\uC0B0\uBD88 \uACBD\uBCF4"},												// Mountain Fire Warning						"��� �溸"
			{"RTW", "\uAD50\uD1B5 \uD1B5\uC81C"},												// Regulate Traffic Warning					"���� ����"
		
			// ����
			{"EAN", "\uAD6D\uAC00 \uBE44\uC0C1 \uC0C1\uD669 \uBC1C\uC0DD"}, 					// Emergency Action Notification (National only)		"���� ��� ��Ȳ �߻�"
			{"EAT", "\uAD6D\uAC00 \uBE44\uC0C1 \uC0C1\uD669 \uC885\uB8CC"}, 					// Emergency Action Termination (National only)		"���� ��� ��Ȳ ����"
			{"NIC", "\uC911\uC559 \uC7AC\uB09C \uC548\uC804 \uB300\uCC45 \uBCF8\uBD80"},		// National Information Center					"�߾� �糭 ���� ��å ����"
			{"NPT", "\uC804\uAD6D\uC801 \uC8FC\uAE30 \uD14C\uC2A4\uD2B8"},						// National Periodic Test						"������ �ֱ� �׽�Ʈ"
			{"RMT", "\uC804\uAD6D\uC801 \uC6D4\uBCC4 \uC758\uBB34 \uD14C\uC2A4\uD2B8"},			 // Required Monthly Test						"������ ���� �ǹ� �׽�Ʈ"
			{"RWT", "\uC804\uAD6D\uC801 \uC8FC\uAC04\uBCC4 \uC758\uBB34 \uD14C\uC2A4"},			 // Required Weekly Test						"������ �ְ��� �ǹ� �׽�Ʈ"
		
			// �׽�Ʈ
			{"STT", "\uD2B9\uC218 \uC218\uC2E0\uAE30 \uD14C\uC2A4\uD2B8"},						// Special Terminal Test						"Ư�� ���ű� �׽�Ʈ"
		
			// ����
			{"ADR", "\uD589\uC815 \uBA54\uC2DC\uC9C0"}, 										// Administrative Message						"���� �޽���"
			{"AVW", "\uC0B0\uC0AC\uD0DC \uACBD\uBCF4"}, 										// Avalanche Warning						"����� �溸"
			{"AVA", "\uC0B0\uC0AC\uD0DC \uC8FC\uC758\uBCF4"},									// Avalanche Watch							"����� ���Ǻ�"
			{"BZW", "\uD3ED\uD48D\uC124\uACBD\uBCF4"},											// Blizzard Warning							"��ǳ���溸"
			{"CAE", "\uC5B4\uB9B0\uC774 \uC720\uAD34 \uAE34\uAE09 \uC0C1\uD669"},				// Child Abduction Emergency					"��� ���� ��� ��Ȳ"
			{"CDW", "\uC2DC\uBBFC \uC704\uD5D8 \uC0C1\uD669 \uACBD\uBCF4"}, 					// Civil Danger Warning						"�ù� ���� ��Ȳ �溸"
			{"CEM", "\uC2DC\uBBFC \uC751\uAE09 \uC0C1\uD669 \uBA54\uC2DC\uC9C0"},				// Civil Emergency Message					"�ù� ���� ��Ȳ �޽���"
			{"CFW", "\uD574\uC548 \uCE68\uC218 \uACBD\uBCF4"},									// Coastal Flood Warning						"�ؾ� ħ�� �溸"
			{"CFA", "\uD574\uC548 \uCE68\uC218 \uC8FC\uC758\uBCF4"},							// Coastal Flood Watch						"�ؾ� ħ�� ���Ǻ�"
			{"DSW", "\uBAA8\uB798 \uD3ED\uD48D \uACBD\uBCF4"},									// Dust Storm Warning						"�� ��ǳ �溸"
			{"EQW", "\uC9C0\uC9C4 \uACBD\uBCF4"},												// Earthquake Warning						"���� �溸"
			{"EVI", "\uC989\uC2DC \uB300\uD53C"},												// Evacuation Immediate						"��� ����"
			{"FRW", "\uD654\uC7AC \uACBD\uBCF4"},												// Fire Warning								"ȭ�� �溸"
			{"FFW", "\uAE34\uAE09 \uD64D\uC218 \uACBD\uBCF4"},									// Flash Flood Warning						"��� ȫ�� �溸"
			{"FFA", "\uAE34\uAE09 \uD64D\uC218 \uC8FC\uC758\uBCF4"},							// Flash Flood Watch							"��� ȫ�� ���Ǻ�"
			{"FFS", "\uAE34\uAE09 \uD64D\uC218 \uC0C1\uD669"},									// Flash Flood Statement						"��� ȫ�� ��Ȳ"
			{"FLW", "\uD64D\uC218 \uACBD\uBCF4"},												// Flood Warning							"ȫ�� �溸"
			{"FLA", "\uD64D\uC218 \uC8FC\uC758\uBCF4"}, 										// Flood Watch								"ȫ�� ���Ǻ�"
			{"FLS", "\uD64D\uC218 \uC0C1\uD669"},												// Flood Statement							"ȫ�� ��Ȳ"
			{"HMW", "\uC704\uD5D9 \uBB3C\uC9C8 \uACBD\uBCF4"},									// Hazardous Materials Warning					"���� ���� �溸"
			{"HWW", "\uAC15\uD48D \uACBD\uBCF4"},												// High Wind Warning						"��ǳ �溸"
			{"HWA", "\uAC15\uD48D \uC8FC\uC758\uBCF4"}, 										// High Wind Watch							"��ǳ ���Ǻ�"
			{"HUW", "\uD0DC\uD48D \uACBD\uBCF4"},												// Hurricane Warning							"��ǳ �溸"
			{"HUA", "\uD0DC\uD48D \uC8FC\uC758\uBCF4"}, 										// Hurricane Watch							"��ǳ ���Ǻ�"
			{"HLS", "\uD0DC\uD48D\uC815\uBCF4"},												// Hurricane Statement						"��ǳ����"
			{"LEW", "\uBC95\uC9D1\uD589 \uACBD\uACE0"}, 										// Law Enforcement Warning					"������ ���"
			{"LAE", "\uC9C0\uC5ED \uAE34\uAE09 \uC0C1\uD669"},									// Local Area Emergency						"���� ��� ��Ȳ"
			{"NMN", "\uD1B5\uC2E0 \uBA54\uC2DC\uC9C0 \uC54C\uB9BC"},							// Network Message Notification					"��� ������ �˸�"
			{"TOE", "\u0031\u0031\u0039\uC804\uD654 \uBD88\uD1B5 \uC751\uAE09 \uC0C1\uD669"},	// 119 Telephone Outage Emergency				"119��ȭ ���� ���� ��Ȳ"
			{"NUW", "\uD575\uBC1C\uC804\uC18C \uAD00\uB828 \uACBD\uBCF4"},						// Nuclear Power Plant Warning					"�ٹ����� ���� �溸"
			{"DMO", "\uC5F0\uC2B5\u002F\uC2DC\uC5F0 \uACBD\uBCF4"},								// Practice/Demo Warning						"����/�ÿ� �溸"
			{"RHW", "\uBC29\uC0AC\uB2A5 \uC704\uD5D8 \uACBD\uBCF4"},							// Radiological Hazard Warning					"���� ���� �溸"
			{"SVR", "\uB1CC\uC6B0 \uACBD\uBCF4"},												// Severe Thunderstorm Warning				"���� �溸"
			{"SVA", "\uB1CC\uC6B0 \uC8FC\uC758\uBCF4"}, 										// Severe Thunderstorm Watch					"���� ���Ǻ�"
			{"SVS", "\uC545\uAE30\uC0C1\uC815\uBCF4"},											// Severe Weather Statement					"�Ǳ������"
			{"SPW", "\uC548\uC804\uD55C \uC7A5\uC18C\uB85C \uD53C\uB09C \uACBD\uBCF4"}, 		// Shelter in Place Warning					"������ ��ҷ� �ǳ� �溸"
			{"SMW", "\uD2B9\uC218 \uD574\uC591 \uACBD\uBCF4"},									// Special Marine Warning						"Ư�� �ؾ� �溸"
			{"SPS", "\uD2B9\uC774 \uAE30\uC0C1 C815\uBCF4"},									// Special Weather Statement					"Ư�� ��� ����"
			{"TOR", "\uD1A0\uB124\uC774\uB3C4 \uACBD\uBCF4"},									// Tornado Warning							"����̵� �溸"
			{"TOA", "\uD1A0\uB124\uC774\uB3C4 \uC8FC\uC758\uBCF4"}, 							// Tornado Watch							"����̵� ���Ǻ�"
			{"TRW", "\uC5F4\uB300 \uD3ED\uD48D(\uD0DC\uD48D) \uACBD\uBCF4"},					// Tropical Storm Warning						"���� ��ǳ(��ǳ) �溸"
			{"TRA", "\uC5F4\uB300 \uD3ED\uD48D(\uD0DC\uD48D) \uC8FC\uC758\uBCF4"},				// Tropical Storm Watch						"���� ��ǳ(��ǳ) ���Ǻ�"
			{"TSW", "\uC9C0\uC9C4\uD574\uC77C \uACBD\uBCF4"},									// Tsunami Warning							"�������� �溸"
			{"TSA", "\uC9C0\uC9C4\uD574\uC77C \uC8FC\uC758\uBCF4"}, 							// Tsunami Watch							"�������� ���Ǻ�"
			{"VOW", "\uD654\uC0B0 \uACBD\uBCF4"},												// Volcano Warning							"ȭ�� �溸"
			{"WSW", "\uB208\uD3ED\uD48D \uACBD\uBCF4"}, 										// Winter Storm Warning						"����ǳ �溸"
			{"WSA", "\uB208\uD3ED\uD48D \uC8FC\uC758\uBCF4"},									// Winter Storm Watch						"����ǳ ���Ǻ�"
		};

		ews_priority = new String[]
		{
			"Unknown",							// 
			"\uBCF4\uD1B5",						// ����
			"\uAE34\uAE09",						// ���
			"\uB9E4\uC6B0 \uAE34\uAE09",		// �ſ� ���
		};

		ews_Seoul_code_index = new int[]
		{
			0x14000000,
			0x17000000,
			0x20000000,
			0x21500000,
			0x23000000,
			0x26000000,
			0x29000000,
			0x30500000,
			0x32000000,
			0x35000000,
			0x38000000,
			0x41000000,
			0x44000000,
			0x47000000,
			0x50000000,
			0x53000000,
			0x54500000,
			0x56000000,
			0x59000000,
			0x62000000,
			0x65000000,
			0x68000000,
			0x71000000,
			0x74000000,
		};
		ews_Seoul_code = new String[]
		{
			"\uC911\uAD6C",						// "�߱�"
			"\uC6A9\uC0B0\uAD6C",				// "��걸"
			"\uC131\uB3D9\uAD6C",				// "������"
			"\uAD11\uC9C4\uAD6C",				// "������"
			"\uB3D9\uB300\uBB38\uAD6C",			// "���빮��"
			"\uC911\uB791\uAD6C",				// "�߶���"
			"\uC131\uBD81\uAD6C",				// "���ϱ�"
			"\uAC15\uBD81\uAD6C",				// "���ϱ�"
			"\uB3C4\uBD09\uAD6C",				// "������"
			"\uB178\uC6D0\uAD6C",				// "�����"
			"\uC740\uD3C9\uAD6C",				// "����"
			"\uC11C\uB300\uBB38\uAD6C",			// "���빮��"
			"\uB9C8\uD3EC\uAD6C",				// "������"
			"\uC591\uCC9C\uAD6C",				// "��õ��"
			"\uAC15\uC11C\uAD6C",				// "������"
			"\uAD6C\uB85C\uAD6C",				// "���α�"
			"\uAE08\uCC9C\uAD6C",				// "��õ��"
			"\uC601\uB4F1\uD3EC\uAD6C",			// "��������"
			"\uB3D9\uC791\uAD6C",				// "���۱�"
			"\uAD00\uC545\uAD6C",				// "���Ǳ�"
			"\uC11C\uCD08\uAD6C",				// "���ʱ�"
			"\uAC15\uB0A8\uAD6C",				// "������"
			"\uC1A1\uD30C\uAD6C",				// "���ı�"
			"\uAC15\uB3D9\uAD6C",				// "������"
		};

		ews_Busan_code_index = new int[]
		{
			0x11000000,
			0x14000000,
			0x17000000,
			0x20000000,
			0x23000000,
			0x26000000,
			0x29000000,
			0x32000000,
			0x35000000,
			0x38000000,
			0x41000000,
			0x44000000,
			0x47000000,
			0x50000000,
			0x53000000,
			0x71000000,
		};
		ews_Busan_code = new String[]
		{
			"\uC911\uAD6C",						// "�߱�"
			"\uC11C\uAD6C",						// "����"
			"\uB3D9\uAD6C",						// "����"
			"\uC601\uB3C4\uAD6C",				// "������"
			"\uBD80\uC0B0\uC9C4\uAD6C",			// "�λ�����"
			"\uB3D9\uB798\uAD6C",				// "������"
			"\uB0A8\uAD6C",						// "����"
			"\uBD81\uAD6C",						// "�ϱ�"
			"\uD574\uC6B4\uB300\uAD6C",			// "�ؿ�뱸"
			"\uC0AC\uD558\uAD6C",				// "���ϱ�"
			"\uAE08\uC815\uAD6C",				// "������"
			"\uAC15\uC11C\uAD6C",				// "������"
			"\uC5F0\uC81C\uAD6C",				// "������"
			"\uC218\uC601\uAD6C",				// "������"
			"\uC0AC\uC0C1\uAD6C",				// "���"
			"\uAE30\uC7A5\uAD70",				// "���屺"
		};

		ews_Daegu_code_index = new int[]
		{
			0x11000000,
			0x14000000,
			0x17000000,
			0x20000000,
			0x23000000,
			0x26000000,
			0x29000000,
			0x71000000,
		};
		ews_Daegu_code = new String[]
		{
			"\uC911\uAD6C",						// "�߱�"
			"\uB3D9\uAD6C",						// "����"
			"\uC11C\uAD6C",						// "����"
			"\uB0A8\uAD6C",						// "����"
			"\uBD81\uAD6C",						// "�ϱ�"
			"\uC218\uC131\uAD6C",				// "������"
			"\uB2EC\uC11C\uAD6C",				// "�޼���"
			"\uB2EC\uC131\uAD70",				// "�޼���"
		};

		ews_Incheon_code_index = new int[]
		{
			0x11000000,
			0x11500000,
			0x11600000,
			0x14000000,
			0x17000000,
			0x18500000,
			0x20000000,
			0x23700000,
			0x24500000,
			0x26000000,
			0x26500000,
			0x71000000,
			0x72000000,
		};
		ews_Incheon_code = new String[]
		{
			"\uC911\uAD6C",							// "�߱�"
			"\uC911\uAD6C\uC601\uC885\uCD9C\uC7A5",	// "�߱���������"
			"\uC911\uAD6C\uC6A9\uC720\uCD9C\uC7A5",	// "�߱���������"
			"\uB3D9\uAD6C",							// "����"
			"\uB0A8\uAD6C",							// "����"
			"\uC5F0\uC218\uAD6C",					// "������"
			"\uB0A8\uB3D9\uAD6C",					// "������"
			"\uBD80\uD3C9\uAD6C",					// "����"
			"\uACC4\uC591\uAD6C",					// "��籸"
			"\uC11C\uAD6C",							// "����"
			"\uC11C\uAD6C\uAC80\uB2E8\uCD9C\uC7A5",	// "�����˴�����"
			"\uAC15\uD654\uAD70",					// "��ȭ��"
			"\uC639\uC9C4\uAD70",					// "������"
		};

		ews_Gwangju_code_index = new int[]
		{
			0x11000000,
			0x14000000,
			0x15500000,
			0x17000000,
			0x20000000,
		};
		ews_Gwangju_code = new String[]
		{
			"\uB3D9\uAD6C",							// "����"
			"\uC11C\uAD6C",							// "����"
			"\uB0A8\uAD6C",							// "����"
			"\uBD81\uAD6C",							// "�ϱ�"
			"\uAD11\uC0B0\uAD6C",					// "���걸"
		};

		ews_Daejeon_code_index = new int[]
		{
			0x11000000,
			0x14000000,
			0x17000000,
			0x20000000,
			0x23000000,
		};
		ews_Daejeon_code = new String[]
		{
			"\uB3D9\uAD6C",							// "����"
			"\uC911\uAD6C",							// "�߱�"
			"\uC11C\uAD6C",							// "����"
			"\uC720\uC131\uAD6C",					// "������"
			"\uB300\uB355\uAD6C",					// "�����"
		};

		ews_Ulsan_code_index = new int[]
		{
			0x11000000,
			0x14000000,
			0x17000000,
			0x20000000,
			0x71000000,
		};
		ews_Ulsan_code = new String[]
		{
			"\uC911\uAD6C",							// "�߱�"
			"\uB0A8\uAD6C",							// "����"
			"\uB3D9\uAD6C",							// "����"
			"\uBD81\uAD6C",							// "�ϱ�"
			"\uC6B8\uC8FC\uAD70",					// "���ֱ�"
		};

		ews_Gyeonggi_code_index = new int[]
		{
			0x10500000,
			0x11000000,
			0x11100000,
			0x11300000,
			0x11500000,
			0x11700000,
			0x13000000,
			0x13100000,
			0x13300000,
			0x13500000,
			0x15000000,
			0x17000000,
			0x17100000,
			0x17300000,
			0x19000000, 
			0x19500000, 
			0x19700000, 
			0x19900000, 
			0x21000000, 
			0x22000000, 
			0x25000000, 
			0x27000000, 
			0x27100000, 
			0x27300000, 
			0x28000000, 
			0x28100000, 
			0x28500000, 
			0x28700000, 
			0x29000000, 
			0x31000000, 
			0x36000000, 
			0x37000000, 
			0x39000000, 
			0x41000000, 
			0x43000000, 
			0x45000000, 
			0x46000000, 
			0x46100000, 
			0x46300000, 
			0x46500000, 
			0x48000000, 
			0x50000000, 
			0x55000000, 
			0x57000000, 
			0x59000000, 
			0x61000000, 
			0x63000000, 
			0x65000000, 
			0x73000000, 
			0x80000000, 
			0x82000000, 
			0x83000000, 
		};
		ews_Gyeonggi_code = new String[]
		{
 			 "\uBD81\uBD80\uCD9C\uC7A5\uC18C",			// "�Ϻ������"
			 "\uC218\uC6D0\uC2DC",						// "������"
			 "\uC218\uC6D0\uC2DC\uC7A5\uC548\uAD6C",	// "��������ȱ�"
			 "\uC218\uC6D0\uC2DC\uAD8C\uC120\uAD6C",	// "�����ñǼ���"
			 "\uC218\uC6D0\uC2DC\uD314\uB2EC\uAD6C",	// "�������ȴޱ�"
			 "\uC218\uC6D0\uC2DC\uC601\uD1B5\uAD6C",	// "�����ÿ��뱸"
			 "\uC131\uB0A8\uC2DC",						// "������"
			 "\uC131\uB0A8\uC2DC\uC218\uC815\uAD6C",	// "�����ü�����"
			 "\uC131\uB0A8\uC2DC\uC911\uC6D0\uAD6C",	// "�������߿���"
			 "\uC131\uB0A8\uC2DC\uBD84\uB2F9\uAD6C",	// "�����úд籸"
			 "\uC758\uC815\uBD80\uC2DC",				// "�����ν�"
			 "\uC548\uC591\uC2DC",						// "�Ⱦ��"
			 "\uC548\uC591\uC2DC\uB9CC\uC548\uAD6C",	// "�Ⱦ�ø��ȱ�"
			 "\uC548\uC591\uC2DC\uB3D9\uC548\uAD6C",	// "�Ⱦ�õ��ȱ�"
			 "\uBD80\uCC9C\uC2DC",						// "��õ��"
			 "\uBD80\uCC9C\uC2DC\uC6D0\uBBF8\uAD6C", 	// "��õ�ÿ��̱�"
			 "\uBD80\uCC9C\uC2DC\uC18C\uC0AC\uAD6C",	// "��õ�üһ籸"
			 "\uBD80\uCC9C\uC2DC\uC624\uC815\uAD6C",	// "��õ�ÿ�����"
			 "\uAD11\uBA85\uC2DC",						// "�����"
			 "\uD3C9\uD0DD\uC2DC",						// "���ý�"
			 "\uB3D9\uB450\uCC9C\uC2DC",				// "����õ��"
			 "\uC548\uC0B0\uC2DC",						// "�Ȼ��"
			 "\uC548\uC0B0\uC2DC\uC0C1\uB85D\uAD6C",	// "�Ȼ�û�ϱ�"
			 "\uC548\uC0B0\uC2DC\uB2E8\uC6D0\uAD6C",	// "�Ȼ�ôܿ���"
			 "\uACE0\uC591\uC2DC", 						//  "����"
			 "\uACE0\uC591\uC2DC\uB355\uC591\uAD6C",	// "���ô��籸"
			 "\uACE0\uC591\uC2DC\uC77C\uC0B0\uB3D9",	// "�����ϻ굿"
			 "\uACE0\uC591\uC2DC\uC77C\uC0B0\uC11C",	// "�����ϻ꼭"
			 "\uACFC\uCC9C\uC2DC", 						//  "��õ��"
			 "\uAD6C\uB9AC\uC2DC",						// "������"
			 "\uB0A8\uC591\uC8FC\uC2DC",				// "�����ֽ�"
			 "\uC624\uC0B0\uC2DC",						// "�����"
			 "\uC2DC\uD765\uC2DC",						// "�����"
			 "\uAD70\uD3EC\uC2DC",						// "������"
			 "\uC758\uC655\uC2DC",						// "�ǿս�"
			 "\uD558\uB0A8\uC2DC",						// "�ϳ���"
			 "\uC6A9\uC778\uC2DC",						// "���ν�"
			 "\uC6A9\uC778\uC2DC\uCC98\uC778\uAD6C",	// "���ν�ó�α�"
			 "\uC6A9\uC778\uC2DC\uAE30\uD765\uAD6C",	// "���νñ��ﱸ"
			 "\uC6A9\uC778\uC2DC\uC218\uC9C0\uAD6C",	// "���νü�����"
			 "\uD30C\uC8FC\uC2DC",						// "���ֽ�"
			 "\uC774\uCC9C\uC2DC",						// "��õ��"
			 "\uC548\uC131\uC2DC",						// "�ȼ���"
			 "\uAE40\uD3EC\uC2DC",						// "������"
			 "\uD654\uC131\uC2DC",						// "ȭ����"
			 "\uAD11\uC8FC\uC2DC",						// "���ֽ�"
			 "\uC591\uC8FC\uC2DC",						// "���ֽ�"
			 "\uD3EC\uCC9C\uC2DC",						// "��õ��"
			 "\uC5EC\uC8FC\uAD70",						// "���ֱ�"
			 "\uC5F0\uCC9C\uAD70",						// "��õ��"
			 "\uAC00\uD3C9\uAD70",						// "����"
			 "\uC591\uD3C9\uAD70",						// "����"
		};

		ews_Gangwon_code_index = new int[]
		{
 			0x10500000, 
			0x11000000, 
			0x13000000, 
			0x15000000, 
			0x17000000, 
			0x19000000, 
			0x21000000, 
			0x23000000, 
			0x72000000, 
			0x73000000, 
			0x75000000, 
			0x76000000, 
			0x77000000, 
			0x78000000, 
			0x79000000, 
			0x80000000, 
			0x81000000, 
			0x82000000, 
			0x83000000, 
		};
		 ews_Gangwon_code = new String[]
		{
 			 "\uB3D9\uD574\uCD9C\uC7A5\uC18C",			// "���������"
			 "\uCD98\uCC9C\uC2DC",						// "��õ��"
			 "\uC6D0\uC8FC\uC2DC",						// "���ֽ�"
			 "\uAC15\uB989\uC2DC",						// "������"
			 "\uB3D9\uD574\uC2DC",						// "���ؽ�"
			 "\uD0DC\uBC31\uC2DC",						// "�¹��"
			 "\uC18D\uCD08\uC2DC",						// "���ʽ�"
			 "\uC0BC\uCC99\uC2DC",						// "��ô��"
			 "\uD64D\uCC9C\uAD70",						// "ȫõ��"
			 "\uD6A1\uC131\uAD70",						// "Ⱦ����"
			 "\uB3D9\uC6D4\uAD70",						// "������"
			 "\uD3C9\uCC3D\uAD70",						// "��â��"
			 "\uC815\uC120\uAD70",						// "������"
			 "\uCCA0\uC6D0\uAD70",						// "ö����"
			 "\uD654\uCC9C\uAD70",						// "ȭõ��"
			 "\uC591\uAD6C\uAD70",						// "�籸��"
			 "\uC778\uC81C\uAD70",						// "������"
			 "\uACE0\uC131\uAD70",						// "����"
			 "\uC591\uC591\uAD70",						// "��籺"
		};

		ews_Chungbuk_code_index = new int[]
		{
			0x11000000,
			0x11100000,
			0x11300000,
			0x13000000,
			0x15000000,
			0x71000000,
			0x72000000,
			0x73000000,
			0x74000000,
			0x74500000,
			0x75000000,
			0x76000000,
			0x77000000,
			0x80000000,
		};
		ews_Chungbuk_code = new String[]
		{
			"\uCCAD\uC8FC\uC2DC",						// "û�ֽ�"
			"\uCCAD\uC8FC\uC2DC\uC0C1\uB2F9\uAD6C",		// "û�ֽû�籸"
			"\uCCAD\uC8FC\uC2DC\uD765\uB355\uAD6C",		// "û�ֽ������"
			"\uCDA9\uC8FC\uC2DC",						// "���ֽ�"
			"\uC81C\uCC9C\uC2DC",						// "��õ��"
			"\uCCAD\uC6D0\uAD70",						// "û����"
			"\uBCF4\uC740\uAD70",						// "������"
			"\uC625\uCC9C\uAD70",						// "��õ��"
			"\uC601\uB3D9\uAD70",						// "������"
			"\uC99D\uD3C9\uAD70",						// "����"
			"\uC9C4\uCC9C\uAD70",						// "��õ��"
			"\uAD34\uC0B0\uAD70",						// "���걺"
			"\uC74C\uC131\uAD70",						// "������"
			"\uB2E8\uC591\uAD70",						// "�ܾ籺"
		};

		ews_Chungnam_code_index = new int[]
		{
			0x13000000,
			0x13100000,
			0x13300000,
			0x15000000,
			0x18000000,
			0x20000000,
			0x21000000,
			0x23000000,
			0x25000000,
			0x71000000,
			0x73000000,
			0x76000000,
			0x77000000,
			0x79000000,
			0x80000000,
			0x81000000,
			0x82500000,
			0x83000000,
		};
		ews_Chungnam_code = new String[]
		{
			"\uCC9C\uC548\uC2DC",						// "õ�Ƚ�"
			"\uCC9C\uC548\uC2DC\uB3D9\uB0A8\uAD6C",		// "õ�Ƚõ�����"
			"\uCC9C\uC548\uC2DC\uC11C\uBD81\uAD6C",		// "õ�Ƚü��ϱ�"
			"\uACF5\uC8FC\uC2DC",						// "���ֽ�"
			"\uBCF4\uB839\uC2DC",						// "���ɽ�"
			"\uC544\uC0B0\uC2DC",						// "�ƻ��"
			"\uC11C\uC0B0\uC2DC",						// "�����"
			"\uB17C\uC0B0\uC2DC",						// "����"
			"\uACC4\uB8E1\uC2DC",						// "����"
			"\uAE08\uC0B0\uAD70",						// "�ݻ걺"
			"\uC5F0\uAE30\uAD70",						// "���ⱺ"
			"\uBD80\uC5EC\uAD70",						// "�ο���"
			"\uC11C\uCC9C\uAD70",						// "��õ��"
			"\uCCAD\uC591\uAD70",						// "û�籺"
			"\uD64D\uC131\uAD70",						// "ȫ����"
			"\uC608\uC0B0\uAD70",						// "���걺"
			"\uD0DC\uC548\uAD70",						// "�¾ȱ�"
			"\uB2F9\uC9C4\uAD70",						// "������"
		};

		ews_Jeonbuk_code_index = new int[]
		{
			0x11000000,
			0x11100000,
			0x11300000,
			0x11800000,
			0x13000000,
			0x14000000,
			0x14500000,
			0x18000000,
			0x19000000,
			0x21000000,
			0x71000000,
			0x72000000,
			0x73000000,
			0x74000000,
			0x75000000,
			0x77000000,
			0x79000000,
			0x80000000, 
		};
		 ews_Jeonbuk_code = new String[]
		{
 			 "\uC804\uC8FC\uC2DC",						// "���ֽ�"
			 "\uC804\uC8FC\uC2DC\uC644\uC0B0\uAD6C",	// "���ֽÿϻ걸"
			 "\uC804\uC8FC\uC2DC\uB355\uC9C4\uAD6C",	// "���ֽô�����"
			 "\uC804\uC8FC\uC2DC\uD6A8\uC790\uCD9C",	// "���ֽ�ȿ����"
			 "\uAD70\uC0B0\uC2DC",						// "�����"
			 "\uC775\uC0B0\uC2DC",						// "�ͻ��"
			 "\uC775\uC0B0\uC2DC\uD568\uC5F4\uCD9C",	// "�ͻ���Կ���"
			 "\uC815\uC74D\uC2DC",						// "������"
			 "\uB0A8\uC6D0\uC2DC",						// "������"
			 "\uAE40\uC81C\uC2DC",						// "������"
			 "\uC644\uC8FC\uAD70",						// "���ֱ�"
			 "\uC9C4\uC548\uAD70",						// "���ȱ�"
			 "\uBB34\uC8FC\uAD70",						// "���ֱ�"
			 "\uC7A5\uC218\uAD70",						// "�����"
			 "\uC784\uC2E4\uAD70",						// "�ӽǱ�"
			 "\uC21C\uCC3D\uAD70",						// "��â��"
			 "\uACE0\uCC3D\uAD70",						// "��â��"
			 "\uBD80\uC548\uAD70",						// "�ξȱ�"
		};

		ews_Jeonnam_code_index = new int[]
		{
			0x11000000,
			0x13000000,
			0x15000000,
			0x17000000,
			0x23000000,
			0x71000000,
			0x72000000,
			0x73000000,
			0x77000000,
			0x78000000,
			0x79000000,
			0x80000000,
			0x81000000,
			0x82000000,
			0x83000000,
			0x84000000,
			0x86000000,
			0x87000000,
			0x88000000,
			0x89000000,
			0x90000000,
			0x91000000,
		};
		ews_Jeonnam_code = new String[]
		{
			"\uBAA9\uD3EC\uC2DC",						// "������"
			"\uC5EC\uC218\uC2DC",						// "������"
			"\uC21C\uCC9C\uC2DC",						// "��õ��"
			"\uB098\uC8FC\uC2DC",						// "���ֽ�"
			"\uAD11\uC591\uC2DC",						// "�����"
			"\uB2F4\uC591\uAD70",						// "��籺"
			"\uACE1\uC131\uAD70",						// "���"
			"\uAD6C\uB840\uAD70",						// "���ʱ�"
			"\uACE0\uD765\uAD70",						// "���ﱺ"
			"\uBCF4\uC131\uAD70",						// "������"
			"\uD654\uC21C\uAD70",						// "ȭ����"
			"\uC7A5\uD765\uAD70",						// "���ﱺ"
			"\uAC15\uC9C4\uAD70",						// "������"
			"\uD574\uB0A8\uAD70",						// "�س���"
			"\uC601\uC554\uAD70",						// "���ϱ�"
			"\uBB34\uC548\uAD70",						// "���ȱ�"
			"\uD568\uD3C9\uAD70",						// "����"
			"\uC601\uAD11\uAD70",						// "������"
			"\uC7A5\uC131\uAD70",						// "�强��"
			"\uC644\uB3C4\uAD70",						// "�ϵ���"
			"\uC9C4\uB3C4\uAD70",						// "������"
			"\uC2E0\uC548\uAD70",						// "�žȱ�"
		};

		ews_Gyeongbuk_code_index = new int[]
		{
			0x11000000,
			0x11100000,
			0x11300000,
			0x13000000,
			0x15000000,
			0x17000000,
			0x19000000,
			0x21000000,
			0x23000000,
			0x25000000,
			0x28000000,
			0x29000000,
			0x72000000,
			0x73000000,
			0x75000000,
			0x76000000,
			0x77000000,
			0x82000000,
			0x83000000,
			0x84000000,
			0x85000000,
			0x90000000,
			0x92000000,
			0x93000000,
			0x94000000,
		};
		ews_Gyeongbuk_code = new String[]
		{
			"\uD3EC\uD56D\uC2DC",						// "���׽�"
			"\uD3EC\uD56D\uC2DC\uB0A8\uAD6C",			// "���׽ó���"
			"\uD3EC\uD56D\uC2DC\uBD81\uAD6C",			// "���׽úϱ�"
			"\uACBD\uC8FC\uC2DC",						// "���ֽ�"
			"\uAE40\uCC9C\uC2DC",						// "��õ��"
			"\uC548\uB3D9\uC2DC",						// "�ȵ���"
			"\uAD6C\uBBF8\uC2DC",						// "���̽�"
			"\uC601\uC8FC\uC2DC",						// "���ֽ�"
			"\uC601\uCC9C\uC2DC",						// "��õ��"
			"\uC0C1\uC8FC\uC2DC",						// "���ֽ�"
			"\uBB38\uACBD\uC2DC",						// "�����"
			"\uACBD\uC0B0\uC2DC",						// "����"
			"\uAD70\uC704\uAD70",						// "������"
			"\uC758\uC131\uAD70",						// "�Ǽ���"
			"\uCCAD\uC1A1\uAD70",						// "û�۱�"
			"\uC601\uC591\uAD70",						// "���籺"
			"\uC601\uB355\uAD70",						// "������"
			"\uCCAD\uB3C4\uAD70",						// "û����"
			"\uACE0\uB839\uAD70",						// "��ɱ�"
			"\uC131\uC8FC\uAD70",						// "���ֱ�"
			"\uCE60\uACE1\uAD70",						// "ĥ�"
			"\uC608\uCC9C\uAD70",						// "��õ��"
			"\uBD09\uD654\uAD70",						// "��ȭ��"
			"\uC6B8\uC9C4\uAD70",						// "������"
			"\uC6B8\uB989\uAD70",						// "�︪��"
		};

		ews_Gyeongnam_code_index = new int[]
		{
			0x11000000,
			0x16000000,
			0x17000000,
			0x19000000,
			0x22000000,
			0x24000000,
			0x24500000,
			0x25000000,
			0x27000000,
			0x31000000,
			0x33000000,
			0x72000000,
			0x73000000,
			0x74000000,
			0x82000000,
			0x84000000,
			0x85000000,
			0x86000000,
			0x87000000,
			0x88000000,
			0x89000000,
		};
		ews_Gyeongnam_code = new String[]
		{
			"\uCC3D\uC6D0\uC2DC",						// "â����"
			"\uB9C8\uC0B0\uC2DC",						// "�����"
			"\uC9C4\uC8FC\uC2DC",						// "���ֽ�"
			"\uC9C4\uD574\uC2DC",						// "���ؽ�"
			"\uD1B5\uC601\uC2DC",						// "�뿵��"
			"\uC0AC\uCC9C\uC2DC",						// "��õ��"
			"\uC0AC\uCC9C\uB0A8\uC591\uCD9C\uC7A5",		// "��õ��������"
			"\uAE40\uD574\uC2DC",						// "���ؽ�"
			"\uBC00\uC591\uC2DC",						// "�о��"
			"\uAC70\uC81C\uC2DC",						// "������"
			"\uC591\uC0B0\uC2DC",						// "����"
			"\uC758\uB839\uAD70",						// "�Ƿɱ�"
			"\uD568\uC548\uAD70",						// "�Ծȱ�"
			"\uCC3D\uB155\uAD70",						// "â�籺"
			"\uACE0\uC131\uAD70",						// "����"
			"\uB0A8\uD574\uAD70",						// "���ر�"
			"\uD558\uB3D9\uAD70",						// "�ϵ���"
			"\uC0B0\uCCAD\uAD70",						// "��û��"
			"\uD568\uC591\uAD70",						// "�Ծ籺"
			"\uAC70\uCC3D\uAD70",						// "��â��"
			"\uD569\uCC9C\uAD70",						// "��õ��"
		};

		ews_Jeju_code_index = new int[]
		{
			0x11000000,
			0x13000000,
		};
		ews_Jeju_code = new String[]
		{
			"\uC81C\uC8FC\uC2DC",						// "���ֽ�"
			"\uC11C\uADC0\uD3EC\uC2DC",					// "��������"
		};

		ews_Local_code_index = new int[]
		{
			0x00,
			0x11,
			0x26,
			0x27,
			0x28,
			0x29,
			0x30,
			0x31,
			0x41,
			0x42,
			0x43,
			0x44,
			0x45,
			0x46,
			0x47,
			0x48,
			0x50,
		};
		ews_Local_code = new String[]
		{
			"\uC804\uAD6D",									// "����"
			"\uC11C\uC6B8\uD2B9\uBCC4\uC2DC",				// "����Ư����"
			"\uBD80\uC0B0\uAD11\uC5ED\uC2DC",				// "�λ걤����"
			"\uB300\uAD6C\uAD11\uC5ED\uC2DC",				// "�뱸������"
			"\uC778\uCC9C\uAD11\uC5ED\uC2DC",				// "��õ������"
			"\uAD11\uC8FC\uAD11\uC5ED\uC2DC",				// "���ֱ�����"
			"\uB300\uC804\uAD11\uC5ED\uC2DC",				// "����������"
			"\uC6B8\uC0B0\uAD11\uC5ED\uC2DC",				// "��걤����"
			"\uACBD\uAE30\uB3C4",							// "��⵵"
			"\uAC15\uC6D0\uB3C4",							// "������"
			"\uCDA9\uCCAD\uBD81\uB3C4",						// "��û�ϵ�"
			"\uCDA9\uCCAD\uB0A8\uB3C4",						// "��û����"
			"\uC804\uB77C\uBD81\uB3C4",						// "����ϵ�"
			"\uC804\uB77C\uB0A8\uB3C4",						// "���󳲵�"
			"\uACBD\uC0C1\uBD81\uB3C4",						// "���ϵ�"
			"\uACBD\uC0C1\uB0A8\uB3C4",						// "��󳲵�"
			"\uC81C\uC8FC\uD2B9\uBCC4\uC790\uCE58\uB3C4",	//"����Ư����ġ��"
		};

		type = new byte[3];
		local_code_main = new int[16];
		local_code_sub = new int[16];
    }

    public String[][] ews_type;
    public String[] ews_priority;

	public int[] ews_Seoul_code_index;
	public String[] ews_Seoul_code;

	public int[] ews_Busan_code_index;
	public String[] ews_Busan_code;

	public int[] ews_Daegu_code_index;
	public String[] ews_Daegu_code;

	public int[] ews_Incheon_code_index;
	public String[] ews_Incheon_code;

	public int[] ews_Gwangju_code_index;
	public String[] ews_Gwangju_code;

	public int[] ews_Daejeon_code_index;
	public String[] ews_Daejeon_code;

	public int[] ews_Ulsan_code_index;
	public String[] ews_Ulsan_code;

	public int[] ews_Gyeonggi_code_index;
	public String[] ews_Gyeonggi_code;

	public int[] ews_Gangwon_code_index;
	public String[] ews_Gangwon_code;

	public int[] ews_Chungbuk_code_index;
	public String[] ews_Chungbuk_code;

	public int[] ews_Chungnam_code_index;
	public String[] ews_Chungnam_code;

	public int[] ews_Jeonbuk_code_index;
	public String[] ews_Jeonbuk_code;

	public int[] ews_Jeonnam_code_index;
	public String[] ews_Jeonnam_code;

	public int[] ews_Gyeongbuk_code_index;
	public String[] ews_Gyeongbuk_code;

	public int[] ews_Gyeongnam_code_index;
	public String[] ews_Gyeongnam_code;

	public int[] ews_Jeju_code_index;
	public String[] ews_Jeju_code;

	public int[] ews_Local_code_index;
	public String[] ews_Local_code;

	public int[] ews_local_code_sub_index;

    public int id;
    public byte[] type;                 // �糭 ����
    public char priority;               // �溸 �켱 ����
    public int time;                    // �糭 �߷� �ð�
    public char local_type;             // �糭 ���� ����
    public char local_count;            // �糭 ���� ��
    public int[] local_code_main;       // �糭 ����(��,���� ����)
    public int[] local_code_sub;        // �糭 ����(��,�� ����)
	public byte[] message;              // �ܹ�

	public String GetLocalSubCode(int index, int subCode)
	{
		int i;
		switch(index)
		{
			case 0:
				break;

			case 1:
				for(i=0; i<ews_Seoul_code.length; i++)
				{
					if(subCode == ews_Seoul_code_index[i])
					{
						return ews_Seoul_code[i];
					}
				}
				break;

			case 2:
				for(i=0; i<ews_Busan_code.length; i++)
				{
					if(subCode == ews_Busan_code_index[i])
					{
						return ews_Busan_code[i];
					}
				}
				break;

			case 3:
				for(i=0; i<ews_Daegu_code.length; i++)
				{
					if(subCode == ews_Daegu_code_index[i])
					{
						return ews_Daegu_code[i];
					}
				}
				break;

			case 4:
				for(i=0; i<ews_Incheon_code.length; i++)
				{
					if(subCode == ews_Incheon_code_index[i])
					{
						return ews_Incheon_code[i];
					}
				}
				break;

			case 5:
				for(i=0; i<ews_Gwangju_code.length; i++)
				{
					if(subCode == ews_Gwangju_code_index[i])
					{
						return ews_Gwangju_code[i];
					}
				}
				break;

			case 6:
				for(i=0; i<ews_Daejeon_code.length; i++)
				{
					if(subCode == ews_Daejeon_code_index[i])
					{
						return ews_Daejeon_code[i];
					}
				}
				break;

			case 7:
				for(i=0; i<ews_Ulsan_code.length; i++)
				{
					if(subCode == ews_Ulsan_code_index[i])
					{
						return ews_Ulsan_code[i];
					}
				}
				break;
				
			case 8:
				for(i=0; i<ews_Gyeonggi_code.length; i++)
				{
					if(subCode == ews_Gyeonggi_code_index[i])
					{
						return ews_Gyeonggi_code[i];
					}
				}
				break;

			case 9:
				for(i=0; i<ews_Gangwon_code.length; i++)
				{
					if(subCode == ews_Gangwon_code_index[i])
					{
						return ews_Gangwon_code[i];
					}
				}
				break;

			case 10:
				for(i=0; i<ews_Chungbuk_code.length; i++)
				{
					if(subCode == ews_Chungbuk_code_index[i])
					{
						return ews_Chungbuk_code[i];
					}
				}
				break;

			case 11:
				for(i=0; i<ews_Chungnam_code.length; i++)
				{
					if(subCode == ews_Chungnam_code_index[i])
					{
						return ews_Chungnam_code[i];
					}
				}
				break;

			case 12:
				for(i=0; i<ews_Jeonbuk_code.length; i++)
				{
					if(subCode == ews_Jeonbuk_code_index[i])
					{
						return ews_Jeonbuk_code[i];
					}
				}
				break;

			case 13:
				for(i=0; i<ews_Jeonnam_code.length; i++)
				{
					if(subCode == ews_Jeonnam_code_index[i])
					{
						return ews_Jeonnam_code[i];
					}
				}
				break;

			case 14:
				for(i=0; i<ews_Gyeongbuk_code.length; i++)
				{
					if(subCode == ews_Gyeongbuk_code_index[i])
					{
						return ews_Gyeongbuk_code[i];
					}
				}
				break;

			case 15:
				for(i=0; i<ews_Gyeongnam_code.length; i++)
				{
					if(subCode == ews_Gyeongnam_code_index[i])
					{
						return ews_Gyeongnam_code[i];
					}
				}
				break;

			case 16:
				for(i=0; i<ews_Jeju_code.length; i++)
				{
					if(subCode == ews_Jeju_code_index[i])
					{
						return ews_Jeju_code[i];
					}
				}
				break;
		}
		return null;
	}

	public int GetLocalSubCodeCount(int index)
	{
		int ret = 0;
		switch(index)
		{
			case 0:
				break;

			case 1:
				ret = ews_Seoul_code.length;
				break;

			case 2:
				ret = ews_Busan_code.length;
				break;

			case 3:
				ret = ews_Daegu_code.length;
				break;

			case 4:
				ret = ews_Incheon_code.length;
				break;

			case 5:
				ret = ews_Gwangju_code.length;
				break;

			case 6:
				ret = ews_Daejeon_code.length;
				break;

			case 7:
				ret = ews_Ulsan_code.length;
				break;
				
			case 8:
				ret = ews_Gyeonggi_code.length;
				break;

			case 9:
				ret = ews_Gangwon_code.length;
				break;

			case 10:
				ret = ews_Chungbuk_code.length;
				break;

			case 11:
				ret = ews_Chungnam_code.length;
				break;

			case 12:
				ret = ews_Jeonbuk_code.length;
				break;

			case 13:
				ret = ews_Jeonnam_code.length;
				break;

			case 14:
				ret = ews_Gyeongbuk_code.length;
				break;

			case 15:
				ret = ews_Gyeongnam_code.length;
				break;

			case 16:
				ret = ews_Jeju_code.length;
				break;
		}
		return ret;
	}
}

