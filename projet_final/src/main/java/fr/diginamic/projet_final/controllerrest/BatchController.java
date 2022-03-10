package fr.diginamic.projet_final.controllerrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.projet_final.model.Absence;
import fr.diginamic.projet_final.repository.iCrudAbsence;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	private iCrudAbsence ca;
	
	@Scheduled(cron = "0 0 14 * * ?")
	@GetMapping(path = "/startB")
	public void batchRtt() throws Exception {
		List<Absence> listRtt = (List<Absence>) ca.getAllRttEmployeurInitiale();
		for (Absence arrayRtt : listRtt) {
			arrayRtt.setStatut("VALIDE");
			ca.save(arrayRtt);
		}
	}

}
