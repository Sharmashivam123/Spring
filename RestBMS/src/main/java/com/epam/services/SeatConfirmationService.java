package com.epam.services;

import java.util.Optional;

public interface SeatConfirmationService {
	public void setSeatIdAndCostList(Optional<String> silverOptional, Optional<String> goldOptional,
			Optional<String> platinumOptional);

}
