package br.site.db.recordingHistory;

import java.io.Serializable;
import java.util.List;

import br.site.model.exercise.Exercise;
import br.site.model.patient.Patient;
import br.site.model.recordingHistory.RecordingHistory;

public interface RecordingHistoryRepository {
	Serializable save(RecordingHistory recordingHistory);
	List<RecordingHistory> recordingsBy(Patient patient, Integer exerciseId);
	List<RecordingHistory> byExercises(List<Exercise> exercises);
}
