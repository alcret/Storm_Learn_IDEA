package org.apache.storm.trident;

import java.util.Map;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;
import storm.trident.spout.ITridentSpout;

public class DiagnosisEventSpout implements ITridentSpout<Long>{
	
	private SpoutOutputCollector collector;
	private BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	private Emitter<Long> emitter = new DiagnosisEventEmmiter();

	public Map getComponentConfiguration() {
		return null;
	}

	public BatchCoordinator<Long> getCoordinator(String txStateId, Map conf, TopologyContext context) {
		return coordinator;
	}

	public Emitter<Long> getEmitter(String txStateId, Map conf, TopologyContext context) {
		return emitter;
	}

	public Fields getOutputFields() {
		return new Fields("event");
	}
}
