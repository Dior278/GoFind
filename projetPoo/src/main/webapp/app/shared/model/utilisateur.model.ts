export interface IUtilisateur {
  id?: number;
  nom?: string | null;
  prenom?: string | null;
  email?: string | null;
  numeroTel?: string | null;
  motDePasse?: string | null;
}

export const defaultValue: Readonly<IUtilisateur> = {};
