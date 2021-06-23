package org.tain.tasks.asynccmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.tain.data.WorkingData;
import org.tain.data.vo.Cmd;
import org.tain.tools.node.MonJsonNode;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Sleep;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AsyncCmdTask {

	@Autowired
	private WorkingData workingData;
	
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	@Async(value = "async_0101")
	public void async_0101(Cmd cmd) throws Exception {
		log.info("KANG-20210615 >>>>> async_0101 START {} {}", cmd, CurrentInfo.get());
		
		if (Boolean.TRUE) {
			System.out.println("+---------------------------------------------+");
			System.out.println("|                                             |");
			System.out.println("|       START of the Asyn                     |");
			System.out.println("|                                             |");
			System.out.println(">>>>> " + cmd);
			System.out.println("+---------------------------------------------+");
		}
		
		if (Boolean.TRUE) {
			int period = Integer.parseInt(cmd.getCmdPeriod());
			/*
			 * cmdPeriod
			 *     - : keep running
			 *     0 : one run
			 *     + : loop wait time
			 */
			if (period < 0) {
				cmdKeepSingle(cmd);
			} else {
				cmdAgainSingle(cmd);
			}
		}
		
		if (Boolean.TRUE) {
			// update table to set stop-flag
			this.workingData.getMapCmd().remove(cmd.getCmdCode());
		}
		
		if (Boolean.TRUE) {
			Sleep.run(1 * 1000);
			System.out.println("+---------------------------------------------+");
			System.out.println("|                                             |");
			System.out.println("|       STOP of the Async                     |");
			System.out.println("|                                             |");
			System.out.println(">>>>> " + cmd);
			System.out.println("+---------------------------------------------+");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	private void cmdKeepSingle(Cmd cmd) throws Exception {
		log.info("KANG-20200721 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			// spring async kill thread
			log.info(">>>>> cmd: {} {}", cmd);
			
			MonJsonNode nodeResult = new MonJsonNode("{}");
			if (Boolean.TRUE) {
				//nodeResult.put("svrCode", cmd.getSvrCode());
				nodeResult.put("msgKey", "RET000");
				nodeResult.put("msgType", "RET");
				nodeResult.put("mstCode", cmd.getMstCode());
				nodeResult.put("svrCode", this.workingData.getInfo().getSvrCode());
				nodeResult.put("cmdCode", cmd.getCmdCode());
				nodeResult.put("cmdPeriod", cmd.getCmdPeriod());
				nodeResult.put("cmdBufLine", cmd.getCmdBufLine());
				nodeResult.put("cmdArr", cmd.getCmdArr());
			}
			
			if (Boolean.TRUE) {
				// run process and get the result
				Process process = Runtime.getRuntime().exec(cmd.getCmdArr());
				int bufLine = Integer.parseInt(cmd.getCmdBufLine());
				int bufIdx = 0;
				StringBuffer sb = new StringBuffer();
				sb.setLength(0);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
				String line = null;
				while ((line = br.readLine()) != null && cmd.isFlgAlive()) {
					if (bufIdx < bufLine) {
						sb.append(line).append("\n");
						bufIdx ++;
					} else {
						nodeResult.put("cmdResult", sb.toString());
						if (Boolean.TRUE) {
							this.workingData.getQueueFromAsyncToCommander().set(nodeResult);
							if (Boolean.TRUE) System.out.println(">>>>> queue.set.nodeResult: " + nodeResult.toPrettyString());
						}
						sb.setLength(0);
						bufIdx = 0;
					}
				}
				
				if (Boolean.TRUE) {
					@SuppressWarnings("unused")
					int exitVal = process.waitFor();
					process.destroy();
				}
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	private void cmdAgainSingle(Cmd cmd) throws Exception {
		log.info("KANG-20200721 >>>>> {} {}", CurrentInfo.get());
		
		if (Boolean.TRUE) {
			int period = Integer.parseInt(cmd.getCmdPeriod());
			
			// spring async kill thread
			for (int idx=0; cmd.isFlgAlive(); idx++) {
				log.info(">>>>> cmd: {} {}", cmd, idx);
				MonJsonNode nodeResult = new MonJsonNode("{}");
				if (Boolean.TRUE) {
					//nodeResult.put("svrCode", cmd.getSvrCode());
					nodeResult.put("msgKey", "RET000");
					nodeResult.put("msgType", "RET");
					nodeResult.put("mstCode", cmd.getMstCode());
					nodeResult.put("svrCode", this.workingData.getInfo().getSvrCode());
					nodeResult.put("cmdCode", cmd.getCmdCode());
					nodeResult.put("cmdPeriod", cmd.getCmdPeriod());
					nodeResult.put("cmdBufLine", cmd.getCmdBufLine());
					nodeResult.put("cmdArr", cmd.getCmdArr());
				}
				
				StringBuffer sb = null;
				String line = null;
				Process process = null;
				if (Boolean.TRUE) {
					// run process and get the result
					sb = new StringBuffer();
					process = Runtime.getRuntime().exec(cmd.getCmdArr());
				}
				
				if (Boolean.TRUE) {
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));  // OUTPUT ?EUC-KR
					while ((line = br.readLine()) != null) {
						sb.append(line).append("\n");
					}
				}
				
				if (Boolean.TRUE) {
					BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));  // ERROR ?EUC-KR
					while ((line = br.readLine()) != null) {
						sb.append(line).append("\n");
					}
				}
				
				if (Boolean.TRUE) {
					@SuppressWarnings("unused")
					int exitVal = process.waitFor();
					@SuppressWarnings("unused")
					int len = sb.length();
					process.destroy();
					
					nodeResult.put("cmdResult", sb.toString());
				}
				
				if (Boolean.TRUE) {
					this.workingData.getQueueFromAsyncToCommander().set(nodeResult);
					if (Boolean.TRUE) System.out.println(">>>>> queue.set.nodeResult: " + nodeResult.toPrettyString());
				}
				
				// if period == 0, then to single command
				if (period == 0)
					break;
				
				// sleep, wait for period
				Sleep.run(Integer.parseInt(cmd.getCmdPeriod()) * 1000);
			}
		}
	}
}
