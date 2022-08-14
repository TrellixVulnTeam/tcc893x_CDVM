/****************************************************************************

Copyright (C) 2013 Telechips Inc.


Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions 
andlimitations under the License.

****************************************************************************/

#define LOG_NDEBUG 0
#include <utils/Log.h>

#include "tcc_dxb_manager_alticas.h"
#include "tcc_alticas.h"

 
/*****************************************************************************************
define
*****************************************************************************************/
#define DEBUG_PRINTF		//ALOGE

/*****************************************************************************************
Interface API
*****************************************************************************************/

/**************************************************************************
 FUNCTION NAME : CA_get_unique_id
 
 DESCRIPTION : TeleChips �� CAS PL���� ������ �ĺ��ڸ� �о�´�. 
 
 INPUT	 :  CA_UINT32 unique_id_max_size : The maximum size of unique id
 OUTPUT  : CA_INT8* unique_id : The unique ID of TeleChips terminal
		     CA_UINT32 *unique_id_size : The size of unique
return  : 0 : success
		-1 : fail
**************************************************************************/
CA_INT32 CA_get_unique_id(CA_INT8 *unique_id, CA_UINT32 unique_id_max_size, CA_UINT32 *unique_id_size)
{
	int	err;
	err = tcc_manager_cas_get_unique_id(unique_id, unique_id_max_size, unique_id_size);
	return err;	
}

/**************************************************************************
 FUNCTION NAME : CA_set_cw
 
 DESCRIPTION : TeleChips �� CAS PL�� CW�� �����ϱ� ���� ����Ѵ�.
				. ENCRYPTION_TYPE alg == ALG_NONE �� ��� ���� �����ϰ� �ִ� Descrambling �۾��� �����.
				. descramble_iv_len == 0�� ��� Initial Vector�� ������� �ʴ´�. ��, descramble_iv = NULL�� �ȴ�.
				 Packet descrambling�� MPEG2 TS packet header�� scrambling control �ʵ带 ���� �Ǵ��Ѵ�.
				<Scrambling control value (2 bits): The following per DVB spec[1]>
					Value				Description
					00				Not scrambled
					01				Reserved for future use
					10				Scrambled with even key
					11				Scrambled with odd key
 INPUT	 :  . ENCRYPTION_TYPE alg : Encryption type for descrambling
			. ENCRYPTION_MODE_TYPE mode : Encryption mode for descrambling
			. CA_UNIT32 video_pid : The video pid for descrambling
			. CA_UNIT32 audio_pid : The audio pid for descrambling
			. CA_UNIT32 descramble_key_len : The key length for descrambling
			. CA_UINT8* descramble_key : The key for descrambling
			. CA_UNIT32 descramble_iv_len : The length of IV (Initial Vector) for descrambling // Default Setting : 0
			. CA_UINT8* descramble_iv : The IV(Initial Vector) for descrambling
			. CA_UNIT32 flag : EVEN, ODD ����
 OUTPUT  : NONE
return  : 0 : success
		-1 : fail
**************************************************************************/
CA_INT32 CA_set_cw(ENCRYPTION_TYPE alg,
	ENCRYPTION_MODE_TYPE mode,
	CA_UINT32 video_pid,
	CA_UINT32 audio_pid,
	CA_UINT32 descramble_key_len,
	CA_UINT8 * descramble_key,
	CA_UINT32 descramble_iv_len,
	CA_UINT8 * descramble_iv,
	CA_UINT32 flag)

{
	int err;
	err = tcc_manager_cas_set_cw(alg, mode, video_pid, audio_pid, descramble_key_len, descramble_key, descramble_iv_len, descramble_iv, flag);
	return err;	
}


/**************************************************************************
 FUNCTION NAME : CA_start_packet_filtering
 
 DESCRIPTION : �� �Լ��� altiCAS ���� �ʿ��� Packet Section�� ��û�ϱ� ���� Callback API�� ����ϴ� �Լ��̴�.
				. table_id_mask�� table_id�� 1byte�� ������ ���� ������ �Ѵ�.
				(Section_data_buf[0] & table_id_mask == table_id)
				. ��µǴ� handle�� ���� ���ǰ� �ִ� �ٸ� handle�� �ߺ����� �ʴ� ������ ���̾�� �Ѵ�.
				. ���� �ش� �Լ��� ��ȯ ���� -1(fail)�� ��� handle �� ���� -1�� �Ѵ�.
 INPUT	 :  . CA_UINT32 pid : The PID of a section to be filtered
			. CA_INT8 *table_id_mask : The table id mask
			. CA_INT8* table_id : The table id of a section to be filtered
			. CA_section_callback func : The callback function which will be invoked when the requested section is arrived
			. CA_UINT32 buffsize : The maximum buffer size of section to be filtered
 OUTPUT  :CA_INT32* handle : The section request handle to be set by this function
return  : 0 : success
		-1 : fail
**************************************************************************/
CA_INT32 CA_start_packet_filtering (CA_INT32* handle, 
	CA_UINT32 pid, 
	CA_INT8* table_id_mask, 
	CA_INT8* table_id, 
	CA_section_callback func, 
	CA_UINT32 buffsize)

{
	int err;
	err = tcc_manager_cas_start_packet_filtering(handle, pid, table_id_mask, table_id, func, buffsize);
	return err;
}

/**************************************************************************
 FUNCTION NAME : CA_stop_packet_filtering
 
 DESCRIPTION : �� �Լ��� altiCAS�� ��û�� Callback API�� ����ϴ� �Լ��̴�. 
 					�� �Լ��� ȣ��� ���Ŀ��� ����� Callback API�� ȣ��Ǿ�� �� �ȴ�.
 INPUT	 : CA_INT32 handle : The handle of the section request to be canceled
 OUTPUT : NONE
return  : 0 : success
		-1 : fail
**************************************************************************/
CA_INT32 CA_stop_packet_filtering (CA_INT32 handle)
{
	int	err = 0 ;
	err = tcc_manager_cas_stop_packet_filtering(handle);
	return err;
}



