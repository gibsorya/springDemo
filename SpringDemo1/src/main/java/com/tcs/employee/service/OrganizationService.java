package com.tcs.employee.service;

import com.tcs.employee.model.Organization;
import com.tcs.employee.repository.OrganizationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class OrganizationService {
	
	@Autowired
	OrganizationRepository organizationRepo;
	
	public String addOrganization(Organization organization) {
		return organizationRepo.addOrganization(organization);
	}

	public String updateOrganization(long ID) {
		return organizationRepo.updateOrganization(ID);
	}

	public String deleteOrganization(long ID) {
		return organizationRepo.deleteOrganization(ID);
	}
	
	public Optional<Organization> findById(long ID) {
		return organizationRepo.findById(ID);
	}

	public Optional<List<Organization>> getOrganizations() {
		return organizationRepo.getOrganizations();
	}

	public Optional<List<Organization>> findByOrganizationId(long ID) {
		return organizationRepo.findByOrganizationId(ID);
	}
}
